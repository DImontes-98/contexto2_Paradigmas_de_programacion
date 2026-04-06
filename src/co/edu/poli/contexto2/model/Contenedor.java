package co.edu.poli.contexto2.model;

/**
 * Representa un contenedor de almacenamiento que puede albergar alimentos
 * y estar equipado con sensores de monitoreo.
 * <p>
 * Gestiona información estructural, logística y de contenido del contenedor,
 * incluyendo sus dimensiones, estado, materiales y elementos asociados.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Contenedor c = new Contenedor("ContenedorA", 101, 20240101.0, "Grande",
 *     10, 5000.0, "Activo", 200.0, "Acero", "MarcaX", sensores, alimentos);
 * System.out.println(c.getNombre());
 * }</pre>
 */
public class Contenedor {

    /** Nombre identificador del contenedor. */
    private String nombre;

    /** Código numérico único del contenedor. */
    private int codigo;

    /** Fecha asociada al contenedor representada como valor numérico. */
    private double fecha;

    /** Tamaño o dimensión del contenedor (por ejemplo, pequeño, mediano, grande). */
    private String tamano;

    /** Cantidad de unidades o elementos almacenados en el contenedor. */
    private int cantidad;

    /** Costo asociado al contenedor. */
    private double costo;

    /** Estado actual del contenedor (por ejemplo, activo, inactivo, en mantenimiento). */
    private String estado;

    /** Peso del contenedor en la unidad de medida correspondiente. */
    private double peso;

    /** Material con el que está fabricado el contenedor. */
    private String material;

    /** Marca o fabricante del contenedor. */
    private String marca;

    /** Arreglo de sensores instalados en el contenedor. */
    private Sensor[] sensor;

    /** Arreglo de alimentos almacenados dentro del contenedor. */
    private Alimento[] alimento;

    // Constructor __sobrecargado__
    /**
     * Crea una nueva instancia de {@code Contenedor} con todos sus atributos.
     *
     * @param nombre   nombre identificador del contenedor
     * @param codigo   código numérico único del contenedor
     * @param fecha    fecha asociada al contenedor como valor numérico
     * @param tamano   tamaño o dimensión del contenedor
     * @param cantidad cantidad de unidades almacenadas
     * @param costo    costo del contenedor
     * @param estado   estado actual del contenedor
     * @param peso     peso del contenedor
     * @param material material de fabricación del contenedor
     * @param marca    marca o fabricante del contenedor
     * @param sensor   arreglo de sensores instalados
     * @param alimento arreglo de alimentos almacenados
     */
    public Contenedor(String nombre, int codigo, double fecha, String tamano,
                      int cantidad, double costo, String estado, double peso,
                      String material, String marca, Sensor[] sensor, Alimento[] alimento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
        this.tamano = tamano;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
        this.peso = peso;
        this.material = material;
        this.marca = marca;
        this.sensor = sensor;
        this.alimento = alimento;
    }

    // Getters
    /**
     * Retorna el nombre del contenedor.
     *
     * @return nombre del contenedor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el código numérico del contenedor.
     *
     * @return código del contenedor
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna la fecha asociada al contenedor.
     *
     * @return fecha como {@code double}
     */
    public double getFecha() {
        return fecha;
    }

    /**
     * Retorna el tamaño del contenedor.
     *
     * @return tamaño del contenedor
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * Retorna la cantidad de unidades almacenadas en el contenedor.
     *
     * @return cantidad como {@code int}
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Retorna el costo del contenedor.
     *
     * @return costo como {@code double}
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Retorna el estado actual del contenedor.
     *
     * @return estado del contenedor
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Retorna el peso del contenedor.
     *
     * @return peso como {@code double}
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Retorna el material de fabricación del contenedor.
     *
     * @return material del contenedor
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Retorna la marca del contenedor.
     *
     * @return marca del contenedor
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Retorna el arreglo de sensores instalados en el contenedor.
     *
     * @return arreglo de {@code Sensor}
     */
    public Sensor[] getSensor() {
        return sensor;
    }

    /**
     * Retorna el arreglo de alimentos almacenados en el contenedor.
     *
     * @return arreglo de {@code Alimento}
     */
    public Alimento[] getAlimento() {
        return alimento;
    }

    // Setters
    /**
     * Establece el nombre del contenedor.
     *
     * @param nombre nuevo nombre del contenedor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el código numérico del contenedor.
     *
     * @param codigo nuevo código del contenedor
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la fecha asociada al contenedor.
     *
     * @param fecha nueva fecha como {@code double}
     */
    public void setFecha(double fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el tamaño del contenedor.
     *
     * @param tamano nuevo tamaño del contenedor
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * Establece la cantidad de unidades almacenadas en el contenedor.
     *
     * @param cantidad nueva cantidad como {@code int}
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece el costo del contenedor.
     *
     * @param costo nuevo costo como {@code double}
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Establece el estado actual del contenedor.
     *
     * @param estado nuevo estado del contenedor
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece el peso del contenedor.
     *
     * @param peso nuevo peso como {@code double}
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Establece el material de fabricación del contenedor.
     *
     * @param material nuevo material del contenedor
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Establece la marca del contenedor.
     *
     * @param marca nueva marca del contenedor
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Establece el arreglo de sensores del contenedor.
     *
     * @param sensor nuevo arreglo de {@code Sensor}
     */
    public void setSensor(Sensor[] sensor) {
        this.sensor = sensor;
    }

    /**
     * Establece el arreglo de alimentos almacenados en el contenedor.
     *
     * @param alimento nuevo arreglo de {@code Alimento}
     */
    public void setAlimento(Alimento[] alimento) {
        this.alimento = alimento;
    }

    // __Metodo__ toString
    /**
     * Retorna una representación en cadena del objeto {@code Contenedor}.
     * <p>
     * Incluye todos los atributos del contenedor, incluyendo los arreglos
     * de sensores y alimentos en formato legible.
     * </p>
     *
     * @return representación textual del objeto {@code Contenedor}
     */
    @Override
    public String toString() {
        return "Contenedor{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", fecha=" + fecha +
                ", tamano='" + tamano + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                ", estado='" + estado + '\'' +
                ", peso=" + peso +
                ", material='" + material + '\'' +
                ", marca='" + marca + '\'' +
                ", sensor=" + java.util.Arrays.toString(sensor) +
                ", alimento=" + java.util.Arrays.toString(alimento) +
                '}';
    }

    // __Metodos__ __adicionales__ __del__ __diagrama__
    /**
     * Calcula la capacidad del contenedor según una medida dada.
     *
     * @param medida valor de referencia para el cálculo de capacidad
     * @return capacidad calculada como {@code double}
     */
    public double calcularcapacidad(double medida) {
        return 0.0;
    }

    /**
     * Calcula la durabilidad del contenedor comparándola con el estado actual.
     *
     * @param actual estado o condición actual del contenedor a evaluar
     * @return descripción de la durabilidad estimada como {@code String}
     */
    public String calculardurabilidad(String actual) {
        return "";
    }
}