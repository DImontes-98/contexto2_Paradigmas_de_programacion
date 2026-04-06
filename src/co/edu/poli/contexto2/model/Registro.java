package co.edu.poli.contexto2.model;

/**
 * Representa un registro de inventario o control que asocia alimentos
 * y un tripulante responsable dentro del sistema.
 * <p>
 * Permite gestionar la trazabilidad de los alimentos registrados,
 * indicando su cantidad, durabilidad y el tripulante a cargo.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Registro r = new Registro("RegistroA", "2024-01-01", "REG-001",
 *     10, true, alimentos, tripulante);
 * System.out.println(r.getNombre());
 * }</pre>
 */
public class Registro {

    /** Nombre identificador del registro. */
    private String nombre;

    /** Fecha de creación o referencia del registro. */
    private String fecha;

    /** Código único del registro. */
    private String codigo;

    /** Cantidad de elementos registrados. */
    private int cantidad;

    /** Indica si los alimentos registrados son duraderos. */
    private boolean duradero;

    /** Arreglo de alimentos asociados al registro. */
    private Alimento[] alimento;

    /** Tripulante responsable del registro. */
    private Tripulante tripulante;

    // Constructor __sobrecargado__
    /**
     * Crea una nueva instancia de {@code Registro} con todos sus atributos.
     *
     * @param nombre     nombre identificador del registro
     * @param fecha      fecha de creación o referencia
     * @param codigo     código único del registro
     * @param cantidad   cantidad de elementos registrados
     * @param duradero   {@code true} si los alimentos son duraderos
     * @param alimento   arreglo de alimentos asociados
     * @param tripulante tripulante responsable del registro
     */
    public Registro(String nombre, String fecha, String codigo, int cantidad,
                    boolean duradero, Alimento[] alimento, Tripulante tripulante) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.duradero = duradero;
        this.alimento = alimento;
        this.tripulante = tripulante;
    }

    // Getters
    /**
     * Retorna el nombre del registro.
     *
     * @return nombre del registro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la fecha del registro.
     *
     * @return fecha como {@code String}
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Retorna el código único del registro.
     *
     * @return código del registro
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna la cantidad de elementos registrados.
     *
     * @return cantidad como {@code int}
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Indica si los alimentos del registro son duraderos.
     *
     * @return {@code true} si son duraderos, {@code false} en caso contrario
     */
    public boolean isDuradero() {
        return duradero;
    }

    /**
     * Retorna el arreglo de alimentos asociados al registro.
     *
     * @return arreglo de {@code Alimento}
     */
    public Alimento[] getAlimento() {
        return alimento;
    }

    /**
     * Retorna el tripulante responsable del registro.
     *
     * @return instancia de {@code Tripulante}
     */
    public Tripulante getTripulante() {
        return tripulante;
    }

    // Setters
    /**
     * Establece el nombre del registro.
     *
     * @param nombre nuevo nombre del registro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la fecha del registro.
     *
     * @param fecha nueva fecha como {@code String}
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el código único del registro.
     *
     * @param codigo nuevo código del registro
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la cantidad de elementos registrados.
     *
     * @param cantidad nueva cantidad como {@code int}
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece si los alimentos del registro son duraderos.
     *
     * @param duradero {@code true} si son duraderos
     */
    public void setDuradero(boolean duradero) {
        this.duradero = duradero;
    }

    /**
     * Establece el arreglo de alimentos asociados al registro.
     *
     * @param alimento nuevo arreglo de {@code Alimento}
     */
    public void setAlimento(Alimento[] alimento) {
        this.alimento = alimento;
    }

    /**
     * Establece el tripulante responsable del registro.
     *
     * @param tripulante nueva instancia de {@code Tripulante}
     */
    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }

    // __Método__ toString
    /**
     * Retorna una representación en cadena del objeto {@code Registro},
     * incluyendo todos sus atributos, el arreglo de alimentos y el tripulante asociado.
     *
     * @return representación textual del objeto {@code Registro}
     */
    @Override
    public String toString() {
        return "Registro{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                ", duradero=" + duradero +
                ", alimento=" + java.util.Arrays.toString(alimento) +
                ", tripulante=" + tripulante +
                '}';
    }

    // __Método__ __adicional__ __del__ __diagrama__
    /**
     * Calcula la responsabilidad asociada al registro según el estado actual.
     *
     * @param actual estado o condición actual a evaluar
     * @return descripción de la responsabilidad calculada como {@code String}
     */
    public String calcularresponsabilidad(String actual) {
        return "";
    }
}