package co.edu.poli.contexto2.model;

/**
 * Representa un combustible con sus propiedades físicas, químicas y de inventario.
 * <p>
 * Permite gestionar información sobre el tipo, marca, fecha, características
 * de peligrosidad y disponibilidad del combustible.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Combustible c = new Combustible("Diesel", "Shell", "2024-01-01",
 *     true, false, false, true, 500.0, "SN-001");
 * System.out.println(c.getTipo());
 * }</pre>
 */
public class Combustible {

    /** Tipo de combustible (por ejemplo, Diesel, Gasolina, Gas natural). */
    private String tipo;

    /** Marca o proveedor del combustible. */
    private String marca;

    /** Fecha de registro o vencimiento del combustible. */
    private String fecha;

    /** Indica si el combustible es inflamable. */
    private boolean esinflamable;

    /** Indica si el combustible es renovable. */
    private boolean esrenovable;

    /** Indica si el combustible es corrosivo. */
    private boolean escorrosivo;

    /** Indica si el combustible es contaminante. */
    private boolean escontaminante;

    /** Cantidad disponible del combustible. */
    private double cantidad;

    /** Número serial único que identifica el lote o registro del combustible. */
    private String serial;

    // Constructor __sobrecargado__
    /**
     * Crea una nueva instancia de {@code Combustible} con todos sus atributos.
     *
     * @param tipo           tipo de combustible
     * @param marca          marca o proveedor del combustible
     * @param fecha          fecha de registro o vencimiento
     * @param esinflamable   {@code true} si el combustible es inflamable
     * @param esrenovable    {@code true} si el combustible es renovable
     * @param escorrosivo    {@code true} si el combustible es corrosivo
     * @param escontaminante {@code true} si el combustible es contaminante
     * @param cantidad       cantidad disponible del combustible
     * @param serial         número serial del lote o registro
     */
    public Combustible(String tipo, String marca, String fecha,
                       boolean esinflamable, boolean esrenovable, boolean escorrosivo,
                       boolean escontaminante, double cantidad, String serial) {
        this.tipo = tipo;
        this.marca = marca;
        this.fecha = fecha;
        this.esinflamable = esinflamable;
        this.esrenovable = esrenovable;
        this.escorrosivo = escorrosivo;
        this.escontaminante = escontaminante;
        this.cantidad = cantidad;
        this.serial = serial;
    }

    // Getters
    /**
     * Retorna el tipo de combustible.
     *
     * @return tipo del combustible
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Retorna la marca del combustible.
     *
     * @return marca del combustible
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Retorna la fecha de registro o vencimiento del combustible.
     *
     * @return fecha como {@code String}
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Indica si el combustible es inflamable.
     *
     * @return {@code true} si es inflamable, {@code false} en caso contrario
     */
    public boolean isEsinflamable() {
        return esinflamable;
    }

    /**
     * Indica si el combustible es renovable.
     *
     * @return {@code true} si es renovable, {@code false} en caso contrario
     */
    public boolean isEsrenovable() {
        return esrenovable;
    }

    /**
     * Indica si el combustible es corrosivo.
     *
     * @return {@code true} si es corrosivo, {@code false} en caso contrario
     */
    public boolean isEscorrosivo() {
        return escorrosivo;
    }

    /**
     * Indica si el combustible es contaminante.
     *
     * @return {@code true} si es contaminante, {@code false} en caso contrario
     */
    public boolean isEscontaminante() {
        return escontaminante;
    }

    /**
     * Retorna la cantidad disponible del combustible.
     *
     * @return cantidad como {@code double}
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Retorna el número serial del combustible.
     *
     * @return serial como {@code String}
     */
    public String getSerial() {
        return serial;
    }

    // Setters
    /**
     * Establece el tipo de combustible.
     *
     * @param tipo nuevo tipo del combustible
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece la marca del combustible.
     *
     * @param marca nueva marca del combustible
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Establece la fecha de registro o vencimiento del combustible.
     *
     * @param fecha nueva fecha como {@code String}
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece si el combustible es inflamable.
     *
     * @param esinflamable {@code true} si es inflamable
     */
    public void setEsinflamable(boolean esinflamable) {
        this.esinflamable = esinflamable;
    }

    /**
     * Establece si el combustible es renovable.
     *
     * @param esrenovable {@code true} si es renovable
     */
    public void setEsrenovable(boolean esrenovable) {
        this.esrenovable = esrenovable;
    }

    /**
     * Establece si el combustible es corrosivo.
     *
     * @param escorrosivo {@code true} si es corrosivo
     */
    public void setEscorrosivo(boolean escorrosivo) {
        this.escorrosivo = escorrosivo;
    }

    /**
     * Establece si el combustible es contaminante.
     *
     * @param escontaminante {@code true} si es contaminante
     */
    public void setEscontaminante(boolean escontaminante) {
        this.escontaminante = escontaminante;
    }

    /**
     * Establece la cantidad disponible del combustible.
     *
     * @param cantidad nueva cantidad como {@code double}
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece el número serial del combustible.
     *
     * @param serial nuevo serial como {@code String}
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    // __Metodo__ toString
    /**
     * Retorna una representación en cadena del objeto {@code Combustible}.
     * <p>
     * Incluye todos los atributos del combustible en formato legible.
     * </p>
     *
     * @return representación textual del objeto {@code Combustible}
     */
    @Override
    public String toString() {
        return "Combustible{" +
                "tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", fecha='" + fecha + '\'' +
                ", esinflamable=" + esinflamable +
                ", esrenovable=" + esrenovable +
                ", escorrosivo=" + escorrosivo +
                ", escontaminante=" + escontaminante +
                ", cantidad=" + cantidad +
                ", serial='" + serial + '\'' +
                '}';
    }

    // __Metodos__ __adicionales__ __del__ __diagrama__
    /**
     * Calcula la confiabilidad del combustible según su índice de octanaje.
     *
     * @param octable {@code true} si cumple con el nivel de octanaje requerido
     * @return {@code true} si el combustible es confiable, {@code false} en caso contrario
     */
    public boolean calcularconfiabilidad(boolean octable) {
        return false;
    }

    /**
     * Calcula si el combustible ha caducado según el inventario registrado.
     *
     * @param inventario identificador o fecha del inventario a evaluar
     * @return {@code true} si el combustible está caducado, {@code false} en caso contrario
     */
    public boolean calcularcaducidad(String inventario) {
        return false;
    }
}