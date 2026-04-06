package co.edu.poli.contexto2.model;

/**
 * Representa una nave de transporte con sus características técnicas,
 * de combustible y de carga.
 * <p>
 * Gestiona información sobre el nombre, dimensiones, material, autonomía,
 * capacidad de carga, combustible asociado y contenedores que transporta.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Nave nave = new Nave("NaveX", 1, "Grande", "Acero", "2024-01-01",
 *     1000.0, 500.0, 3000.0, "MarcaY", combustible, 4.0, contenedores);
 * System.out.println(nave.getNombre());
 * }</pre>
 */
public class Nave {

    /** Nombre identificador de la nave. */
    private String nombre;

    /** Código numérico único de la nave. */
    private int codigo;

    /** Tamaño o dimensión de la nave (por ejemplo, pequeña, mediana, grande). */
    private String tamano;

    /** Material con el que está construida la nave. */
    private String material;

    /** Fecha de registro o fabricación de la nave. */
    private String fecha;

    /** Capacidad máxima de carga de la nave. */
    private double capacidad;

    /** Autonomía de la nave expresada en la unidad de medida correspondiente. */
    private double autonomia;

    /** Peso de la nave en la unidad de medida correspondiente. */
    private double peso;

    /** Marca o fabricante de la nave. */
    private String marca;

    /** Combustible utilizado por la nave. */
    private Combustible combustible;

    /** Número o potencia del motor de la nave. */
    private double motor;

    /** Arreglo de contenedores que transporta la nave. */
    private Contenedor[] contenedor;

    // Constructor __sobrecargado__
    /**
     * Crea una nueva instancia de {@code Nave} con todos sus atributos.
     *
     * @param nombre      nombre identificador de la nave
     * @param codigo      código numérico único de la nave
     * @param tamano      tamaño o dimensión de la nave
     * @param material    material de construcción de la nave
     * @param fecha       fecha de registro o fabricación
     * @param capacidad   capacidad máxima de carga
     * @param autonomia   autonomía de la nave
     * @param peso        peso de la nave
     * @param marca       marca o fabricante de la nave
     * @param combustible combustible utilizado por la nave
     * @param motor       número o potencia del motor
     * @param contenedor  arreglo de contenedores que transporta
     */
    public Nave(String nombre, int codigo, String tamano, String material, String fecha,
                double capacidad, double autonomia, double peso, String marca,
                Combustible combustible, double motor, Contenedor[] contenedor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tamano = tamano;
        this.material = material;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.autonomia = autonomia;
        this.peso = peso;
        this.marca = marca;
        this.combustible = combustible;
        this.motor = motor;
        this.contenedor = contenedor;
    }

    // Getters
    /**
     * Retorna el nombre de la nave.
     *
     * @return nombre de la nave
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el código numérico de la nave.
     *
     * @return código de la nave
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna el tamaño de la nave.
     *
     * @return tamaño de la nave
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * Retorna el material de construcción de la nave.
     *
     * @return material de la nave
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Retorna la fecha de registro o fabricación de la nave.
     *
     * @return fecha como {@code String}
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Retorna la capacidad máxima de carga de la nave.
     *
     * @return capacidad como {@code double}
     */
    public double getCapacidad() {
        return capacidad;
    }

    /**
     * Retorna la autonomía de la nave.
     *
     * @return autonomía como {@code double}
     */
    public double getAutonomia() {
        return autonomia;
    }

    /**
     * Retorna el peso de la nave.
     *
     * @return peso como {@code double}
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Retorna la marca o fabricante de la nave.
     *
     * @return marca de la nave
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Retorna el combustible utilizado por la nave.
     *
     * @return instancia de {@code Combustible} asociada a la nave
     */
    public Combustible getCombustible() {
        return combustible;
    }

    /**
     * Retorna el número o potencia del motor de la nave.
     *
     * @return motor como {@code double}
     */
    public double getMotor() {
        return motor;
    }

    /**
     * Retorna el arreglo de contenedores que transporta la nave.
     *
     * @return arreglo de {@code Contenedor}
     */
    public Contenedor[] getContenedor() {
        return contenedor;
    }

    // Setters
    /**
     * Establece el nombre de la nave.
     *
     * @param nombre nuevo nombre de la nave
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el código numérico de la nave.
     *
     * @param codigo nuevo código de la nave
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece el tamaño de la nave.
     *
     * @param tamano nuevo tamaño de la nave
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * Establece el material de construcción de la nave.
     *
     * @param material nuevo material de la nave
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Establece la fecha de registro o fabricación de la nave.
     *
     * @param fecha nueva fecha como {@code String}
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece la capacidad máxima de carga de la nave.
     *
     * @param capacidad nueva capacidad como {@code double}
     */
    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Establece la autonomía de la nave.
     *
     * @param autonomia nueva autonomía como {@code double}
     */
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    /**
     * Establece el peso de la nave.
     *
     * @param peso nuevo peso como {@code double}
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Establece la marca o fabricante de la nave.
     *
     * @param marca nueva marca de la nave
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Establece el combustible utilizado por la nave.
     *
     * @param combustible nueva instancia de {@code Combustible}
     */
    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    /**
     * Establece el número o potencia del motor de la nave.
     *
     * @param motor nuevo valor del motor como {@code double}
     */
    public void setMotor(double motor) {
        this.motor = motor;
    }

    /**
     * Establece el arreglo de contenedores que transporta la nave.
     *
     * @param contenedor nuevo arreglo de {@code Contenedor}
     */
    public void setContenedor(Contenedor[] contenedor) {
        this.contenedor = contenedor;
    }

    // __Metodo__ toString
    /**
     * Retorna una representación en cadena del objeto {@code Nave}.
     * <p>
     * Incluye todos los atributos de la nave, el combustible asociado
     * y el arreglo de contenedores en formato legible.
     * </p>
     *
     * @return representación textual del objeto {@code Nave}
     */
    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", tamano='" + tamano + '\'' +
                ", material='" + material + '\'' +
                ", fecha='" + fecha + '\'' +
                ", capacidad=" + capacidad +
                ", autonomia=" + autonomia +
                ", peso=" + peso +
                ", marca='" + marca + '\'' +
                ", combustible=" + combustible +
                ", motor=" + motor +
                ", contenedor=" + java.util.Arrays.toString(contenedor) +
                '}';
    }

    // __Metodo__ __adicional__ __del__ __diagrama__
    /**
     * Calcula el consumo de combustible de la nave según la distancia a recorrer.
     *
     * @param distancia distancia a recorrer en la unidad de medida correspondiente
     * @return consumo estimado de combustible como {@code double}
     */
    public double calcularconsumo(double distancia) {
        return 0.0;
    }
}