package co.edu.poli.contexto2.model;

/**
 * Representa un sensor de monitoreo instalado en un contenedor.
 * <p>
 * Almacena las características operativas del sensor, tales como
 * sensibilidad, precisión, calibración y automatización, identificado
 * por un código único.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Sensor s = new Sensor(true, true, true, false, "SEN-001");
 * System.out.println(s.getCodigo());
 * }</pre>
 */
public class Sensor {

    /** Indica si el sensor es sensible a variaciones del entorno. */
    private boolean sensible;

    /** Indica si el sensor es preciso en sus mediciones. */
    private boolean espreciso;

    /** Indica si el sensor está calibrado correctamente. */
    private boolean calibrado;

    /** Indica si el sensor opera de forma automática. */
    private boolean automatico;

    /** Código único identificador del sensor. */
    private String codigo;

    // Constructor __sobrecargado__
    /**
     * Crea una nueva instancia de {@code Sensor} con todos sus atributos.
     *
     * @param sensible   {@code true} si el sensor es sensible
     * @param espreciso  {@code true} si el sensor es preciso
     * @param calibrado  {@code true} si el sensor está calibrado
     * @param automatico {@code true} si el sensor es automático
     * @param codigo     código único identificador del sensor
     */
    public Sensor(boolean sensible, boolean espreciso, boolean calibrado,
                  boolean automatico, String codigo) {
        this.sensible = sensible;
        this.espreciso = espreciso;
        this.calibrado = calibrado;
        this.automatico = automatico;
        this.codigo = codigo;
    }

    // Getters
    /**
     * Indica si el sensor es sensible a variaciones del entorno.
     *
     * @return {@code true} si es sensible, {@code false} en caso contrario
     */
    public boolean isSensible() {
        return sensible;
    }

    /**
     * Indica si el sensor es preciso en sus mediciones.
     *
     * @return {@code true} si es preciso, {@code false} en caso contrario
     */
    public boolean isEspreciso() {
        return espreciso;
    }

    /**
     * Indica si el sensor está calibrado correctamente.
     *
     * @return {@code true} si está calibrado, {@code false} en caso contrario
     */
    public boolean isCalibrado() {
        return calibrado;
    }

    /**
     * Indica si el sensor opera de forma automática.
     *
     * @return {@code true} si es automático, {@code false} en caso contrario
     */
    public boolean isAutomatico() {
        return automatico;
    }

    /**
     * Retorna el código único identificador del sensor.
     *
     * @return código del sensor como {@code String}
     */
    public String getCodigo() {
        return codigo;
    }

    // Setters
    /**
     * Establece si el sensor es sensible.
     *
     * @param sensible {@code true} si el sensor es sensible
     */
    public void setSensible(boolean sensible) {
        this.sensible = sensible;
    }

    /**
     * Establece si el sensor es preciso.
     *
     * @param espreciso {@code true} si el sensor es preciso
     */
    public void setEspreciso(boolean espreciso) {
        this.espreciso = espreciso;
    }

    /**
     * Establece si el sensor está calibrado.
     *
     * @param calibrado {@code true} si el sensor está calibrado
     */
    public void setCalibrado(boolean calibrado) {
        this.calibrado = calibrado;
    }

    /**
     * Establece si el sensor opera de forma automática.
     *
     * @param automatico {@code true} si el sensor es automático
     */
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    /**
     * Establece el código único del sensor.
     *
     * @param codigo nuevo código del sensor como {@code String}
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // __Método__ toString
    /**
     * Retorna una representación en cadena del objeto {@code Sensor},
     * incluyendo todos sus atributos operativos y su código identificador.
     *
     * @return representación textual del objeto {@code Sensor}
     */
    @Override
    public String toString() {
        return "Sensor{" +
                "sensible=" + sensible +
                ", espreciso=" + espreciso +
                ", calibrado=" + calibrado +
                ", automatico=" + automatico +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    // __Método__ __adicional__ __del__ __diagrama__
    /**
     * Verifica el estado operativo del sensor según un parámetro de referencia.
     *
     * @param gusto parámetro o criterio de referencia para la verificación
     * @return descripción del estado del sensor como {@code String}
     */
    public String verificarestado(String gusto) {
        return "";
    }}