package co.edu.poli.mvc.controlador;

import co.edu.poli.contexto2.model.Alimento;
import co.edu.poli.contexto2.model.NoPerecedero;
import co.edu.poli.contexto2.model.Perecedero;
import co.edu.poli.contexto2.servicios.Implementacionoperacioncrud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class controlador_formulario {

    private static final String PATH = "src/datos/";
    private static final String FILE = "alimentos.bin";

    private final Implementacionoperacioncrud crud = new Implementacionoperacioncrud();
    private final ObservableList<FilaAlimento> filas = FXCollections.observableArrayList();
    private Stage stagePrincipal;

    @FXML private ToggleGroup  grupoTipo;
    @FXML private RadioButton  rbPerecedero;
    @FXML private RadioButton  rbNoPerecedero;

    @FXML private TextField    txtNombre;
    @FXML private TextField    txtCodigo;
    @FXML private DatePicker   dpFecha;
    @FXML private TextField    txtCosto;
    @FXML private CheckBox     chkRefrigerable;

    @FXML private VBox         panelPerecedero;
    @FXML private Spinner<Integer> spnDias;
    @FXML private ComboBox<String> cmbConservacion;

    @FXML private VBox         panelNoPerecedero;
    @FXML private Spinner<Integer> spnAnos;
    @FXML private ComboBox<String> cmbEmpaque;

    @FXML private TableView<FilaAlimento>      tablaAlimentos;
    @FXML private TableColumn<FilaAlimento, Integer> colCodigo;
    @FXML private TableColumn<FilaAlimento, String>  colNombre;
    @FXML private TableColumn<FilaAlimento, String>  colTipo;
    @FXML private TableColumn<FilaAlimento, String>  colFecha;
    @FXML private TableColumn<FilaAlimento, String>  colCosto;
    @FXML private TableColumn<FilaAlimento, String>  colDetalle;

    @FXML private Label lblContador;
    @FXML private Label lblEstado;

    @FXML private TableView<FilaAlimento>      tablaLista;
    @FXML private TableColumn<FilaAlimento, Integer> lstCodigo;
    @FXML private TableColumn<FilaAlimento, String>  lstNombre;
    @FXML private TableColumn<FilaAlimento, String>  lstTipo;
    @FXML private TableColumn<FilaAlimento, String>  lstFecha;
    @FXML private TableColumn<FilaAlimento, String>  lstCosto;
    @FXML private TableColumn<FilaAlimento, String>  lstDetalle;
    @FXML private Label lblTotalLista;

    @FXML private Label lblResumenCierre;

    private Stage stageLista;
    private Stage stageCierre;

    @FXML
    public void initialize() {
        if (tablaAlimentos != null) {
            colCodigo .setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colNombre .setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colTipo   .setCellValueFactory(new PropertyValueFactory<>("tipo"));
            colFecha  .setCellValueFactory(new PropertyValueFactory<>("fecha"));
            colCosto  .setCellValueFactory(new PropertyValueFactory<>("costo"));
            colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
            tablaAlimentos.setItems(filas);
        }

        if (lstCodigo != null) {
            lstCodigo .setCellValueFactory(new PropertyValueFactory<>("codigo"));
            lstNombre .setCellValueFactory(new PropertyValueFactory<>("nombre"));
            lstTipo   .setCellValueFactory(new PropertyValueFactory<>("tipo"));
            lstFecha  .setCellValueFactory(new PropertyValueFactory<>("fecha"));
            lstCosto  .setCellValueFactory(new PropertyValueFactory<>("costo"));
            lstDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
        }

        if (cmbConservacion != null) cmbConservacion.setValue("Refrigeracion");
        if (cmbEmpaque      != null) cmbEmpaque.setValue("Bolsa hermetica");
    }

    public void setStage(Stage stage) {
        this.stagePrincipal = stage;
        stage.setOnCloseRequest(e -> {
            e.consume();
            cerrarVentana();
        });
    }

    @FXML
    public void actualizarCamposTipo() {
        boolean esPerecedero = rbPerecedero.isSelected();
        panelPerecedero .setVisible(esPerecedero);
        panelPerecedero .setManaged(esPerecedero);
        panelNoPerecedero.setVisible(!esPerecedero);
        panelNoPerecedero.setManaged(!esPerecedero);
    }

    @FXML
    public void crear() {
        try {
            Alimento a = construirAlimento();
            if (a == null) return;
            String resultado = crud.crear(a);
            if (resultado.startsWith("OK")) {
                agregarFila(a);
                actualizarContador();
                limpiarCampos();
                mostrarAlerta("Alimento creado", resultado, Alert.AlertType.INFORMATION);
                lblEstado.setText("Creado: " + a.getNombre());
            } else {
                mostrarAlerta("Error al crear", resultado, Alert.AlertType.WARNING);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Datos invalidos", "Codigo debe ser numero entero y Costo debe ser numero decimal.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void consultar() {
        String codigoStr = txtCodigo.getText().trim();
        if (codigoStr.isEmpty()) {
            mostrarAlerta("Campo requerido", "Ingresa el codigo del alimento a consultar.", Alert.AlertType.WARNING);
            return;
        }
        try {
            int id = Integer.parseInt(codigoStr);
            Alimento a = crud.consultar(id);
            if (a != null) {
                mostrarAlerta("Alimento encontrado", a.describir(), Alert.AlertType.INFORMATION);
                lblEstado.setText("Consultado: " + a.getNombre());
            } else {
                mostrarAlerta("No encontrado", "No existe alimento con codigo " + id, Alert.AlertType.WARNING);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El codigo debe ser un numero entero.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void modificar() {
        String codigoStr = txtCodigo.getText().trim();
        if (codigoStr.isEmpty()) {
            mostrarAlerta("Campo requerido", "Ingresa el codigo del alimento que deseas modificar.", Alert.AlertType.WARNING);
            return;
        }
        try {
            int id = Integer.parseInt(codigoStr);
            Alimento existente = crud.consultar(id);
            if (existente == null) {
                mostrarAlerta("No encontrado", "No existe alimento con codigo " + id + ". Verifica el codigo.", Alert.AlertType.WARNING);
                return;
            }
            Alimento nuevo = construirAlimento();
            if (nuevo == null) return;
            String resultado = crud.modificar(id, nuevo);
            if (resultado.startsWith("OK")) {
                refrescarTabla();
                mostrarAlerta("Alimento modificado", resultado, Alert.AlertType.INFORMATION);
                lblEstado.setText("Modificado codigo: " + id);
                limpiarCampos();
            } else {
                mostrarAlerta("Error al modificar", resultado, Alert.AlertType.WARNING);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Datos invalidos", "El codigo debe ser un numero entero.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void eliminar() {
        try {
            int id = Integer.parseInt(txtCodigo.getText().trim());
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Confirmar eliminacion");
            confirm.setHeaderText("Eliminar alimento con codigo " + id + "?");
            confirm.setContentText("Esta accion no se puede deshacer.");
            confirm.showAndWait().ifPresent(resp -> {
                if (resp == ButtonType.OK) {
                    String resultado = crud.eliminar(id);
                    if (resultado.startsWith("OK")) {
                        filas.removeIf(f -> f.getCodigo() == id);
                        actualizarContador();
                        mostrarAlerta("Alimento eliminado", resultado, Alert.AlertType.INFORMATION);
                        lblEstado.setText("Eliminado codigo: " + id);
                        limpiarCampos();
                    } else {
                        mostrarAlerta("Error al eliminar", resultado, Alert.AlertType.WARNING);
                    }
                }
            });
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingresa un codigo numerico valido.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void abrirVentanaListar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/poli/contexto2/vista/ventana_lista.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            if (tablaLista != null) {
                tablaLista.setItems(filas);
                lblTotalLista.setText("Total: " + filas.size() + " alimento(s)");
            }

            stageLista = new Stage();
            stageLista.setTitle("Todos los registros");
            stageLista.setScene(new Scene(root));
            stageLista.initModality(Modality.WINDOW_MODAL);
            stageLista.initOwner(stagePrincipal);
            stageLista.show();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo abrir la ventana de lista:\n" + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void cerrarVentanaLista() {
        if (stageLista != null) stageLista.close();
    }

    @FXML
    public void serializar() {
        try {
            new java.io.File(PATH).mkdirs();
            String resultado = crud.serializar(PATH, FILE);
            mostrarAlerta("Datos guardados", resultado + "\nRuta: " + PATH + FILE, Alert.AlertType.INFORMATION);
            lblEstado.setText("Datos guardados correctamente.");
        } catch (Exception e) {
            mostrarAlerta("Error al guardar", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void deserializar() {
        try {
            Alimento[] recuperados = crud.deserializar(PATH, FILE);
            if (recuperados != null) {
                filas.clear();
                for (Alimento a : recuperados) {
                    if (a != null) agregarFila(a);
                }
                actualizarContador();
                StringBuilder sb = new StringBuilder("Datos cargados desde: " + PATH + FILE + "\n\n");
                for (Alimento a : recuperados) {
                    if (a != null) sb.append("  - ").append(a.describir()).append("\n");
                }
                mostrarAlerta("Datos cargados", sb.toString(), Alert.AlertType.INFORMATION);
                lblEstado.setText("Datos deserializados: " + filas.size() + " alimento(s).");
            } else {
                mostrarAlerta("Sin datos", "No se encontro archivo en: " + PATH + FILE, Alert.AlertType.WARNING);
            }
        } catch (Exception e) {
            mostrarAlerta("Error al cargar", "Archivo no encontrado o corrupto:\n" + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void cerrarVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/poli/contexto2/vista/ventana_cierre.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            if (lblResumenCierre != null) {
                long count = filas.stream().filter(f -> f != null).count();
                lblResumenCierre.setText("Alimentos en sesion: " + count);
            }

            stageCierre = new Stage();
            stageCierre.setTitle("Cerrar aplicacion");
            stageCierre.setScene(new Scene(root));
            stageCierre.initModality(Modality.APPLICATION_MODAL);
            stageCierre.initOwner(stagePrincipal);
            stageCierre.initStyle(StageStyle.UNDECORATED);
            stageCierre.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseas cerrar la aplicacion?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait().ifPresent(r -> {
                if (r == ButtonType.YES) System.exit(0);
            });
        }
    }

    @FXML
    public void guardarYSalir() {
        try {
            new java.io.File(PATH).mkdirs();
            crud.serializar(PATH, FILE);
        } catch (Exception e) { }
        System.exit(0);
    }

    @FXML
    public void cargarAlAbrir() {
        if (stageCierre != null) stageCierre.close();
        deserializar();
    }

    @FXML
    public void salirSinGuardar() {
        System.exit(0);
    }

    @FXML
    public void cancelarCierre() {
        if (stageCierre != null) stageCierre.close();
    }

    @FXML
    public void minimizarVentana() {
        if (stagePrincipal != null) stagePrincipal.setIconified(true);
    }

    @FXML
    public void maximizarVentana() {
        if (stagePrincipal != null)
            stagePrincipal.setMaximized(!stagePrincipal.isMaximized());
    }

    private Alimento construirAlimento() {
        String nombre = txtNombre.getText().trim();
        String codigoStr = txtCodigo.getText().trim();
        LocalDate fecha  = dpFecha.getValue();
        String costoStr  = txtCosto.getText().trim();

        if (nombre.isEmpty() || codigoStr.isEmpty() || fecha == null || costoStr.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Nombre, Codigo, Fecha y Costo son obligatorios.", Alert.AlertType.WARNING);
            return null;
        }

        int    codigo = Integer.parseInt(codigoStr);
        double costo  = Double.parseDouble(costoStr);
        String fechaStr = fecha.toString();
        boolean ref   = chkRefrigerable.isSelected();

        if (rbPerecedero.isSelected()) {
            int    dias  = spnDias.getValue();
            String cons  = cmbConservacion.getValue() != null ? cmbConservacion.getValue() : "Refrigeracion";
            return new Perecedero(nombre, codigo, fechaStr, "Mediano", 1, costo, "Activo", "General", ref, 1.0, "N/A", dias, cons);
        } else {
            int    anos  = spnAnos.getValue();
            String emp   = cmbEmpaque.getValue() != null ? cmbEmpaque.getValue() : "Bolsa hermetica";
            return new NoPerecedero(nombre, codigo, fechaStr, "Mediano", 1, costo, "Activo", "General", ref, 1.0, "N/A", anos, emp);
        }
    }

    private void agregarFila(Alimento a) {
        String tipo = (a instanceof NoPerecedero) ? "NoPerecedero" : "Perecedero";
        filas.add(new FilaAlimento(a.getCodigo(), a.getNombre(), tipo, a.getFecha(), String.format("$%.2f", a.getCosto()), a.describir()));
    }

    private void refrescarTabla() {
        filas.clear();
        for (Alimento a : crud.getAlimentos()) {
            if (a != null) agregarFila(a);
        }
        actualizarContador();
    }

    private void actualizarContador() {
        int total = (int) filas.stream().filter(f -> f != null).count();
        if (lblContador != null)
            lblContador.setText(total + (total == 1 ? " registro" : " registros"));
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCodigo.clear();
        dpFecha.setValue(null);
        txtCosto.clear();
        chkRefrigerable.setSelected(false);
        if (spnDias != null) spnDias.getValueFactory().setValue(7);
        if (spnAnos != null) spnAnos.getValueFactory().setValue(2);
        if (cmbConservacion != null) cmbConservacion.setValue("Refrigeracion");
        if (cmbEmpaque != null) cmbEmpaque.setValue("Bolsa hermetica");
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static class FilaAlimento {
        private final int    codigo;
        private final String nombre;
        private final String tipo;
        private final String fecha;
        private final String costo;
        private final String detalle;

        public FilaAlimento(int codigo, String nombre, String tipo, String fecha, String costo, String detalle) {
            this.codigo  = codigo;
            this.nombre  = nombre;
            this.tipo    = tipo;
            this.fecha   = fecha;
            this.costo   = costo;
            this.detalle = detalle;
        }

        public int    getCodigo()  { return codigo;  }
        public String getNombre()  { return nombre;  }
        public String getTipo()    { return tipo;    }
        public String getFecha()   { return fecha;   }
        public String getCosto()   { return costo;   }
        public String getDetalle() { return detalle; }
    }
}