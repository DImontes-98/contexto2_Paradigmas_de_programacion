package co.edu.poli.contexto2.model;

/**
 * Representa un tripulante asignado a una nave dentro del sistema de gestión.
 * <p>
 * Almacena la información personal y operativa del tripulante, incluyendo
 * su estado de entrenamiento, peso y código identificador.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Tripulante t = new Tripulante("Juan", "2024-01-01", "TRP-001",
 *     5, "Activo", true, 75.0);
 * System.out.println(t.getNombre());
 * }</pre>
 */
public class Tripulante {

    /** Nombre completo del tripulante. */
    private String nombre;

    /** Fecha de registro o incorporación del tripulante. */
    private String fecha;

    /** Código único identificador del tripulante. */
    private String codigo;

    /** Cantidad de misiones o asignaciones del tripulante. */
    private int cantidad;

    /** Estado operativo actual del tripulante (por ejemplo, activo, inactivo, en reposo). */
    private String estado;

    /** Indica si el tripulante ha completado su entrenamiento. */
    private boolean entrenado;

    /** Peso del tripulante en kilogramos. */
    private double peso;

    // Constructor __sobrecargado__
    /**
     * Crea una nueva instancia de {@code Tripulante} con todos sus atributos.
     *
     * @param nombre     nombre completo del tripulante
     * @param fecha      fecha de registro o incorporación
     * @param codigo     código único identificador del tripulante
     * @param cantidad   cantidad de misiones o asignaciones
     * @param estado     estado operativo actual del tripulante
     * @param entrenado  {@code true} si el tripulante está entrenado
     * @param peso       peso del tripulante en kilogramos
     */
    public Tripulante(String nombre, String fecha, String codigo, int cantidad,
                      String estado, boolean entrenado, double peso) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.estado = estado;
        this.entrenado = entrenado;
        this.peso = peso;
    }

    // Getters
    /**
     * Retorna el nombre del tripulante.
     *
     * @return nombre del tripulante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la fecha de registro del tripulante.
     *
     * @return fecha como {@code String}
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Retorna el código único del tripulante.
     *
     * @return código del tripulante
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna la cantidad de misiones o asignaciones del tripulante.
     *
     * @return cantidad como {@code int}
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Retorna el estado operativo actual del tripulante.
     *
     * @return estado del tripulante
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Indica si el tripulante ha completado su entrenamiento.
     *
     * @return {@code true} si está entrenado, {@code false} en caso contrario
     */
    public boolean isEntrenado() {
        return entrenado;
    }

    /**
     * Retorna el peso del tripulante.
     *
     * @return peso en kilogramos como {@code double}
     */
    public double getPeso() {
        return peso;
    }

    // Setters
    /**
     * Establece el nombre del tripulante.
     *
     * @param nombre nuevo nombre del tripulante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la fecha de registro del tripulante.
     *
     * @param fecha nueva fecha como {@code String}
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el código único del tripulante.
     *
     * @param codigo nuevo código del tripulante
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la cantidad de misiones o asignaciones del tripulante.
     *
     * @param cantidad nueva cantidad como {@code int}
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece el estado operativo actual del tripulante.
     *
     * @param estado nuevo estado del tripulante
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece si el tripulante ha completado su entrenamiento.
     *
     * @param entrenado {@code true} si está entrenado
     */
    public void setEntrenado(boolean entrenado) {
        this.entrenado = entrenado;
    }

    /**
     * Establece el peso del tripulante.
     *
     * @param peso nuevo peso en kilogramos como {@code double}
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    // __Método__ toString
    /**
     * Retorna una representación en cadena del objeto {@code Tripulante},
     * incluyendo todos sus atributos en formato legible.
     *
     * @return representación textual del objeto {@code Tripulante}
     */
    @Override
    public String toString() {
        return "Tripulante{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", entrenado=" + entrenado +
                ", peso=" + peso +
                '}';
    }

    // __Método__ __adicional__ __del__ __diagrama__
    /**
     * Verifica el estado de salud del tripulante según su nivel de adaptabilidad.
     *
     * @param adaptabilidad parámetro o criterio de adaptabilidad a evaluar
     * @return descripción del estado de salud del tripulante como {@code String}
     */
    public String verificarsalud(String adaptabilidad) {
        return "";
    }
}