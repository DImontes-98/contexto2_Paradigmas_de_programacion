package co.edu.poli.contexto2.model;

/**
 * Representa un alimento perecedero, cuya vida útil está limitada
 * a un número determinado de días y requiere condiciones específicas
 * de conservación.
 * <p>
 * Extiende {@code Alimento} e implementa los métodos abstractos
 * {@code calcularDurabilidad} y {@code describir} con base en los
 * días de vencimiento y el tipo de conservación.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Perecedero p = new Perecedero("Leche", 2, "2024-06-01", "Pequeño",
 *     50, 1.5, "Activo", "Cartón", true, 1.0, "ProveedorY", 7, "Refrigeración");
 * System.out.println(p.describir());
 * }</pre>
 */
import java.io.Serializable;

public class Perecedero extends Alimento implements Serializable {


    /** Número de días antes del vencimiento del alimento. */
    private int diasVencimiento;

    /** Tipo de conservación requerida para el alimento (por ejemplo, refrigeración, congelación). */
    private String tipoConservacion;

    /**
     * Crea una nueva instancia de {@code Perecedero} con todos sus atributos,
     * incluyendo los heredados de {@code Alimento}.
     *
     * @param nombre           nombre del alimento
     * @param codigo           código numérico identificador
     * @param fecha            fecha de registro o producción
     * @param tamano           tamaño del alimento o su presentación
     * @param cantidad         cantidad disponible
     * @param costo            costo del alimento
     * @param estado           estado actual del alimento
     * @param recipiente       tipo de recipiente que contiene el alimento
     * @param esrefrigerable   {@code true} si puede refrigerarse
     * @param peso             peso del alimento
     * @param proveedor        nombre del proveedor
     * @param diasVencimiento  número de días antes del vencimiento
     * @param tipoConservacion tipo de conservación requerida
     */
   
    public Perecedero(String nombre, int codigo, String fecha, String tamano,
                      int cantidad, double costo, String estado, String recipiente,
                      boolean esrefrigerable, double peso, String proveedor,
                      int diasVencimiento, String tipoConservacion) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado,
              recipiente, esrefrigerable, peso, proveedor);
        this.diasVencimiento = diasVencimiento;
        this.tipoConservacion = tipoConservacion;
    }
    public Perecedero() {
        super();
    }

    /**
     * Retorna los días restantes antes del vencimiento del alimento.
     *
     * @return días de vencimiento como {@code int}
     */
    public int    getDiasVencimiento()  { return diasVencimiento; }

    /**
     * Retorna el tipo de conservación requerida para el alimento.
     *
     * @return tipo de conservación como {@code String}
     */
    public String getTipoConservacion() { return tipoConservacion; }

    /**
     * Establece los días restantes antes del vencimiento del alimento.
     *
     * @param d nuevos días de vencimiento como {@code int}
     */
    public void setDiasVencimiento(int d)         { this.diasVencimiento = d; }

    /**
     * Establece el tipo de conservación requerida para el alimento.
     *
     * @param t nuevo tipo de conservación como {@code String}
     */
    public void setTipoConservacion(String t)     { this.tipoConservacion = t; }

    /**
     * Calcula la durabilidad del alimento perecedero indicando sus días
     * de vencimiento y el método de conservación requerido.
     *
     * @param vence fecha o referencia de vencimiento a evaluar
     * @return descripción de la durabilidad como {@code String}
     */
    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad es de " + diasVencimiento +
               " dias, conservacion: " + tipoConservacion;
    }

    /**
     * Retorna una descripción detallada del alimento perecedero,
     * incluyendo su nombre, días de vencimiento y tipo de conservación.
     *
     * @return descripción del alimento como {@code String}
     */
    @Override
    public String describir() {
        return "[Perecedero] " + getNombre() +
               " | Vence en " + diasVencimiento + " dias" +
               " | Conservacion: " + tipoConservacion;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Perecedero},
     * incluyendo sus atributos propios y los heredados de {@code Alimento}.
     *
     * @return representación textual del objeto {@code Perecedero}
     */
    @Override
    public String toString() {
        return "Perecedero{diasVencimiento=" + diasVencimiento +
               ", tipoConservacion='" + tipoConservacion +
               "', " + super.toString() + "}";
    }
}