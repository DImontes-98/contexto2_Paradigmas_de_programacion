package co.edu.poli.contexto2.model;

/**
 * Representa un alimento refrigerado, una especialización de {@code Perecedero}
 * que requiere condiciones de temperatura controlada para su conservación.
 * <p>
 * Lleva un contador estático del total de instancias de alimentos refrigerados
 * creadas durante la ejecución del programa.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Refrigerado r = new Refrigerado("Yogur", 3, "2024-06-01", "Pequeño",
 *     30, 2.0, "Activo", "Vaso", true, 0.5, "ProveedorZ",
 *     14, "Refrigeración", 4.0, "Mecánica");
 * System.out.println(r.describir());
 * }</pre>
 */
import java.io.Serializable;

public class Refrigerado extends Perecedero implements Serializable {


    /** Temperatura mínima requerida para la conservación del alimento, en grados Celsius. */
    private double temperaturaMinima;

    /** Tipo de refrigeración utilizada (por ejemplo, mecánica, criogénica). */
    private String tipoRefrigeracion;

    /** Contador estático del total de instancias de {@code Refrigerado} creadas. */
    private static int totalRefrigerados;

    /**
     * Crea una nueva instancia de {@code Refrigerado} con todos sus atributos,
     * incluyendo los heredados de {@code Perecedero} y {@code Alimento}.
     * Incrementa automáticamente el contador estático {@code totalRefrigerados}.
     *
     * @param nombre            nombre del alimento
     * @param codigo            código numérico identificador
     * @param fecha             fecha de registro o producción
     * @param tamano            tamaño del alimento o su presentación
     * @param cantidad          cantidad disponible
     * @param costo             costo del alimento
     * @param estado            estado actual del alimento
     * @param recipiente        tipo de recipiente que contiene el alimento
     * @param esrefrigerable    {@code true} si puede refrigerarse
     * @param peso              peso del alimento
     * @param proveedor         nombre del proveedor
     * @param diasVencimiento   número de días antes del vencimiento
     * @param tipoConservacion  tipo de conservación requerida
     * @param temperaturaMinima temperatura mínima de conservación en grados Celsius
     * @param tipoRefrigeracion tipo de refrigeración utilizada
     */
    public Refrigerado(String nombre, int codigo, String fecha, String tamano,
                       int cantidad, double costo, String estado, String recipiente,
                       boolean esrefrigerable, double peso, String proveedor,
                       int diasVencimiento, String tipoConservacion,
                       double temperaturaMinima, String tipoRefrigeracion) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado, recipiente,
              esrefrigerable, peso, proveedor, diasVencimiento, tipoConservacion);
        this.temperaturaMinima = temperaturaMinima;
        this.tipoRefrigeracion = tipoRefrigeracion;
        totalRefrigerados++;
    }

    /**
     * Retorna la temperatura mínima de conservación del alimento.
     *
     * @return temperatura mínima en grados Celsius como {@code double}
     */
    public double getTemperaturaMinima()  { return temperaturaMinima; }

    /**
     * Retorna el tipo de refrigeración utilizada para conservar el alimento.
     *
     * @return tipo de refrigeración como {@code String}
     */
    public String getTipoRefrigeracion()  { return tipoRefrigeracion; }

    /**
     * Retorna el total acumulado de instancias de {@code Refrigerado} creadas.
     *
     * @return total de refrigerados como {@code int}
     */
    public static int getTotalRefrigerados() { return totalRefrigerados; }

    /**
     * Establece la temperatura mínima de conservación del alimento.
     *
     * @param t nueva temperatura mínima en grados Celsius como {@code double}
     */
    public void setTemperaturaMinima(double t) { this.temperaturaMinima = t; }

    /**
     * Establece el tipo de refrigeración utilizada.
     *
     * @param t nuevo tipo de refrigeración como {@code String}
     */
    public void setTipoRefrigeracion(String t) { this.tipoRefrigeracion = t; }

    /**
     * Establece el contador estático de instancias de {@code Refrigerado}.
     *
     * @param t nuevo valor del contador como {@code int}
     */
    public static void setTotalRefrigerados(int t) { totalRefrigerados = t; }

    /**
     * Retorna el total acumulado de instancias de {@code Refrigerado} creadas.
     * <p>
     * Equivalente a {@link #getTotalRefrigerados()}.
     * </p>
     *
     * @return total de refrigerados como {@code int}
     */
    public static int obtenerTotalRefrigerados() { return totalRefrigerados; }

    /**
     * Calcula la durabilidad del alimento refrigerado indicando el tipo de
     * refrigeración, la temperatura mínima y los días de vencimiento.
     *
     * @param vence fecha o referencia de vencimiento a evaluar
     * @return descripción de la durabilidad refrigerada como {@code String}
     */
    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad refrigerada con " + tipoRefrigeracion +
               " a " + temperaturaMinima + " C: " +
               getDiasVencimiento() + " dias";
    }

    /** __Implementacion__ __del__ __metodo__ __abstracto__ __de__ __Alimento__ */
    /**
     * Retorna una descripción detallada del alimento refrigerado, incluyendo
     * su nombre, temperatura mínima, tipo de refrigeración y días de vencimiento.
     *
     * @return descripción del alimento como {@code String}
     */
    @Override
    public String describir() {
        return "[Refrigerado] " + getNombre() +
               " | Temp. mín: " + temperaturaMinima + "°C" +
               " | Refrigeración: " + tipoRefrigeracion +
               " | Vence en: " + getDiasVencimiento() + " dias";
    }

    /**
     * Retorna una representación en cadena del objeto {@code Refrigerado},
     * incluyendo sus atributos propios, el contador estático y los heredados
     * de {@code Perecedero} y {@code Alimento}.
     *
     * @return representación textual del objeto {@code Refrigerado}
     */
    @Override
    public String toString() {
        return "Refrigerado{temperaturaMinima=" + temperaturaMinima +
               ", tipoRefrigeracion='" + tipoRefrigeracion +
               "', totalRefrigerados=" + totalRefrigerados +
               ", " + super.toString() + "}";
    }
}
