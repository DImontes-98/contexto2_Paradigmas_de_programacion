package co.edu.poli.contexto2.model;

import java.io.Serializable;
 
/**
 * Clase abstracta que representa un alimento dentro del sistema de gestión
 * de inventario alimentario de la institución.
 *
 * <p>Esta clase sirve como base para todos los tipos de alimentos del sistema,
 * definiendo los atributos comunes y los comportamientos generales. Las subclases
 * deben implementar el método abstracto {@link #describir()} para proporcionar
 * una descripción específica según el tipo de alimento.</p>
 *
 * <p><b>Constantes de clase:</b></p>
 * <ul>
 *   <li>{@link #tipoMoneda} - Moneda de referencia para costos (estática, modificable).</li>
 *   <li>{@link #MARCA_CERTIFICADA} - Entidad certificadora oficial (constante de instancia).</li>
 * </ul>
 *
 * @author Estudiante POLI
 * @version 1.0
 * @since 2024
 */
public abstract class Alimento implements Serializable {

    /**
     * Identificador de versión para la serialización.
     * Garantiza compatibilidad entre versiones del objeto serializado.
     */
    private static final long serialVersionUID = 1L;
 
    /**
     * Nombre del alimento.
     * <p>Identifica el producto de forma legible para el usuario,
     * por ejemplo: "Arroz blanco", "Leche entera".</p>
     */
    private String nombre;
 
    /**
     * Código numérico único que identifica el alimento en el sistema.
     * <p>Se utiliza como identificador interno para búsquedas y referencias
     * en base de datos o inventario.</p>
     */
    private int codigo;
 
    /**
     * Fecha asociada al alimento (puede ser fecha de ingreso, producción o vencimiento).
     * <p>Se almacena como cadena de texto en formato libre (por ejemplo: "2024-12-31").</p>
     */
    private String fecha;
 
    /**
     * Tamaño o presentación del alimento.
     * <p>Describe el formato de empaque, por ejemplo: "500g", "1L", "Familiar".</p>
     */
    private String tamano;
 
    /**
     * Cantidad de unidades disponibles del alimento en inventario.
     * <p>Representa el stock actual del producto.</p>
     */
    private int cantidad;
 
    /**
     * Costo unitario del alimento expresado en la moneda definida por {@link #tipoMoneda}.
     * <p>Representa el precio de compra o referencia del producto.</p>
     */
    private double costo;
 
    /**
     * Estado actual del alimento dentro del ciclo de vida del producto.
     * <p>Ejemplos de valores: "Disponible", "Agotado", "Vencido", "En cuarentena".</p>
     */
    private String estado;
 
    /**
     * Tipo de recipiente o empaque en el que se almacena el alimento.
     * <p>Ejemplos: "Bolsa", "Caja", "Tarro", "Botella".</p>
     */
    private String recipiente;
 
    /**
     * Indica si el alimento requiere refrigeración para su conservación.
     * <p>{@code true} si el alimento debe mantenerse en frío;
     * {@code false} si puede almacenarse a temperatura ambiente.</p>
     */
    private boolean esrefrigerable;
 
    /**
     * Peso del alimento expresado en kilogramos (kg) o gramos (g) según la unidad de referencia del sistema.
     * <p>Se utiliza para cálculos de costo por unidad de peso y control de inventario.</p>
     */
    private double peso;
 
    /**
     * Nombre o razón social del proveedor que suministra el alimento.
     * <p>Permite rastrear el origen del producto para efectos de trazabilidad y calidad.</p>
     */
    private String proveedor;
 
    // =========================================================================
    // CONSTANTES
    // =========================================================================
 
    /**
     * Tipo de moneda utilizado para expresar los costos de los alimentos.
     * <p>Valor por defecto: {@code "COP"} (Peso Colombiano). Al ser un campo
     * {@code static}, es compartido por todas las instancias de la clase y puede
     * ser modificado globalmente si se requiere otra divisa.</p>
     */
    public static String tipoMoneda = "COP";
 
    /**
     * Nombre de la entidad certificadora oficial de los alimentos.
     * <p>Valor fijo: {@code "INVIMA"} (Instituto Nacional de Vigilancia de
     * Medicamentos y Alimentos de Colombia). Al ser {@code final}, su valor
     * no puede ser modificado una vez asignado.</p>
     */
    public final String MARCA_CERTIFICADA = "INVIMA";
 
    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
 
    /**
     * Constructor principal que inicializa todos los atributos de un alimento.
     *
     * @param nombre         Nombre descriptivo del alimento (ej. "Leche entera").
     * @param codigo         Código numérico único del alimento en el sistema.
     * @param fecha          Fecha relevante del alimento (ingreso, producción o vencimiento).
     * @param tamano         Tamaño o presentación del empaque (ej. "1L", "500g").
     * @param cantidad       Cantidad de unidades disponibles en inventario.
     * @param costo          Costo unitario del alimento en la moneda {@link #tipoMoneda}.
     * @param estado         Estado actual del alimento (ej. "Disponible", "Vencido").
     * @param recipiente     Tipo de recipiente o empaque del alimento (ej. "Botella", "Caja").
     * @param esrefrigerable {@code true} si el alimento requiere refrigeración; {@code false} en caso contrario.
     * @param peso           Peso del alimento en la unidad de referencia del sistema.
     * @param proveedor      Nombre del proveedor o distribuidor del alimento.
     */
    public Alimento(String nombre, int codigo, String fecha, String tamano,
                    int cantidad, double costo, String estado, String recipiente,
                    boolean esrefrigerable, double peso, String proveedor) {
    	
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
        this.tamano = tamano;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
        this.recipiente = recipiente;
        this.esrefrigerable = esrefrigerable;
        this.peso = peso;
        this.proveedor = proveedor;
    }

    public Alimento() {
    }
 
    // =========================================================================
    // MÉTODOS ABSTRACTOS
    // =========================================================================
 
    /**
     * Devuelve una descripción específica del alimento según su tipo.
     *
     * <p>Cada subclase concreta debe implementar este método para proporcionar
     * información relevante y propia de su categoría de alimento.</p>
     *
     * @return {@code String} con la descripción detallada del alimento.
     */
    public abstract String describir();
 
    // =========================================================================
    // MÉTODOS DE NEGOCIO
    // =========================================================================
 
    /**
     * Calcula el precio final del alimento aplicando posibles impuestos,
     * descuentos o márgenes según las reglas de negocio definidas en la subclase.
     *
     * <p>La implementación base retorna {@code 0.0}. Las subclases pueden
     * sobrescribir este método para aplicar su propia lógica de precio.</p>
     *
     * @return {@code double} con el precio calculado del alimento.
     *         Retorna {@code 0.0} si no se ha definido una lógica específica.
     */
    public double calcularprecio() { return 0.0; }
 
    /**
     * Calcula la durabilidad restante del alimento a partir de su fecha de vencimiento.
     *
     * <p>Compara la fecha de vencimiento proporcionada con la fecha actual o de referencia
     * para determinar cuánto tiempo le queda al producto antes de expirar.</p>
     *
     * @param vence {@code String} con la fecha de vencimiento del alimento
     *              (se recomienda formato "YYYY-MM-DD").
     * @return {@code String} que describe la durabilidad restante del alimento
     *         (ej. "30 días", "Vencido"). Retorna cadena vacía si no se implementa.
     */
    public String calcularDurabilidad(String vence) { return ""; }
 
    /**
     * Evalúa la calidad del alimento en función de su cercanía a la fecha de vencimiento.
     *
     * <p>Permite clasificar el estado del producto según rangos de tiempo antes
     * de su fecha de expiración, por ejemplo: "Óptimo", "Por vencer", "Vencido".</p>
     *
     * @return {@code String} que representa la calificación de calidad según el vencimiento.
     *         Retorna cadena vacía si no se implementa en la subclase.
     */
    public String calcularcalidaddevencimiento() { return ""; }
 
    /**
     * Retorna información básica e identificativa del alimento.
     *
     * <p>Este método es {@code final}, por lo que no puede ser sobrescrito por ninguna subclase.
     * Garantiza un formato uniforme de identificación para todos los alimentos del sistema.</p>
     *
     * @return {@code String} con el nombre y código del alimento en el formato:
     *         {@code "Alimento: [nombre], Codigo: [codigo]"}.
     */
    public final String obtenerInfo() {
        return "Alimento: " + getNombre() + ", Codigo: " + getCodigo();
    }
 
    // =========================================================================
    // GETTERS
    // =========================================================================
 
    /**
     * Retorna el nombre del alimento.
     *
     * @return {@code String} con el nombre del alimento.
     */
    public String getNombre() { return nombre; }
 
    /**
     * Retorna el código único del alimento.
     *
     * @return {@code int} con el código identificador del alimento.
     */
    public int getCodigo() { return codigo; }
 
    /**
     * Retorna la fecha asociada al alimento.
     *
     * @return {@code String} con la fecha del alimento.
     */
    public String getFecha() { return fecha; }
 
    /**
     * Retorna el tamaño o presentación del alimento.
     *
     * @return {@code String} con el tamaño del empaque del alimento.
     */
    public String getTamano() { return tamano; }
 
    /**
     * Retorna la cantidad de unidades disponibles del alimento.
     *
     * @return {@code int} con el número de unidades en inventario.
     */
    public int getCantidad() { return cantidad; }
 
    /**
     * Retorna el costo unitario del alimento.
     *
     * @return {@code double} con el costo del alimento en la moneda {@link #tipoMoneda}.
     */
    public double getCosto() { return costo; }
 
    /**
     * Retorna el estado actual del alimento.
     *
     * @return {@code String} con el estado del alimento (ej. "Disponible", "Vencido").
     */
    public String getEstado() { return estado; }
 
    /**
     * Retorna el tipo de recipiente o empaque del alimento.
     *
     * @return {@code String} con el tipo de recipiente del alimento.
     */
    public String getRecipiente() { return recipiente; }
 
    /**
     * Indica si el alimento requiere refrigeración para su conservación.
     *
     * @return {@code true} si el alimento es refrigerable; {@code false} en caso contrario.
     */
    public boolean isEsrefrigerable() { return esrefrigerable; }
 
    /**
     * Retorna el peso del alimento.
     *
     * @return {@code double} con el peso del alimento.
     */
    public double getPeso() { return peso; }
 
    /**
     * Retorna el nombre del proveedor del alimento.
     *
     * @return {@code String} con el nombre del proveedor o distribuidor.
     */
    public String getProveedor() { return proveedor; }
 
    // =========================================================================
    // SETTERS
    // =========================================================================
 
    /**
     * Establece o actualiza el nombre del alimento.
     *
     * @param nombre {@code String} con el nuevo nombre del alimento.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    /**
     * Establece o actualiza el código identificador del alimento.
     *
     * @param codigo {@code int} con el nuevo código del alimento.
     */
    public void setCodigo(int codigo) { this.codigo = codigo; }
 
    /**
     * Establece o actualiza la fecha asociada al alimento.
     *
     * @param fecha {@code String} con la nueva fecha del alimento.
     */
    public void setFecha(String fecha) { this.fecha = fecha; }
 
    /**
     * Establece o actualiza el tamaño o presentación del alimento.
     *
     * @param tamano {@code String} con el nuevo tamaño del empaque.
     */
    public void setTamano(String tamano) { this.tamano = tamano; }
 
    /**
     * Establece o actualiza la cantidad de unidades en inventario.
     *
     * @param cantidad {@code int} con la nueva cantidad de unidades disponibles.
     */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
 
    /**
     * Establece o actualiza el costo unitario del alimento.
     *
     * @param costo {@code double} con el nuevo costo del alimento en {@link #tipoMoneda}.
     */
    public void setCosto(double costo) { this.costo = costo; }
 
    /**
     * Establece o actualiza el estado actual del alimento.
     *
     * @param estado {@code String} con el nuevo estado del alimento (ej. "Disponible").
     */
    public void setEstado(String estado) { this.estado = estado; }
 
    /**
     * Establece o actualiza el tipo de recipiente o empaque del alimento.
     *
     * @param recipiente {@code String} con el nuevo tipo de recipiente.
     */
    public void setRecipiente(String recipiente) { this.recipiente = recipiente; }
 
    /**
     * Establece o actualiza si el alimento requiere refrigeración.
     *
     * @param v {@code boolean} con el nuevo valor: {@code true} si es refrigerable,
     *          {@code false} si no lo es.
     */
    public void setEsrefrigerable(boolean v) { this.esrefrigerable = v; }
 
    /**
     * Establece o actualiza el peso del alimento.
     *
     * @param peso {@code double} con el nuevo peso del alimento.
     */
    public void setPeso(double peso) { this.peso = peso; }
 
    /**
     * Establece o actualiza el nombre del proveedor del alimento.
     *
     * @param proveedor {@code String} con el nombre del nuevo proveedor o distribuidor.
     */
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
 
    // =========================================================================
    // OVERRIDE
    // =========================================================================
 
    /**
     * Retorna una representación textual completa del alimento con todos sus atributos.
     *
     * <p>Útil para depuración, registros de log o visualización rápida del estado
     * completo del objeto.</p>
     *
     * @return {@code String} con todos los atributos del alimento en formato legible.
     *         Ejemplo: {@code Alimento{nombre='Leche', codigo=101, fecha='2024-12-31', ...}}.
     */
    @Override
    public String toString() {
        return "Alimento{nombre='" + nombre + "', codigo=" + codigo +
               ", fecha='" + fecha + "', tamano='" + tamano +
               "', cantidad=" + cantidad + ", costo=" + costo +
               ", estado='" + estado + "', recipiente='" + recipiente +
               "', esrefrigerable=" + esrefrigerable + ", peso=" + peso +
               ", proveedor='" + proveedor + "'}";
    }
}