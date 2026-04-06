package co.edu.poli.contexto2.model;

/**
 * Representa un alimento no perecedero, es decir, aquel que tiene una larga
 * vida útil medida en años y no requiere condiciones especiales de conservación.
 * <p>
 * Extiende {@code Alimento} e implementa los métodos abstractos
 * {@code calcularDurabilidad} y {@code describir} con base en sus
 * atributos específicos de empaque y años de vida.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * NoPerecedero np = new NoPerecedero("Arroz", 1, "2024-01-01", "Mediano",
 *     100, 2.5, "Activo", "Bolsa", false, 1.0, "ProveedorX", 5, "Vacío");
 * System.out.println(np.describir());
 * }</pre>
 */
import java.io.Serializable;

public class NoPerecedero extends Alimento implements Serializable {

    /** Años de vida útil del alimento no perecedero. */
    private int anosVida;

    /** Tipo de empaque utilizado para preservar el alimento. */
    private String tipoEmpaque;

    /**
     * Crea una nueva instancia de {@code NoPerecedero} con todos sus atributos,
     * incluyendo los heredados de {@code Alimento}.
     *
     * @param nombre         nombre del alimento
     * @param codigo         código numérico identificador
     * @param fecha          fecha de registro o producción
     * @param tamano         tamaño del alimento o su presentación
     * @param cantidad       cantidad disponible
     * @param costo          costo del alimento
     * @param estado         estado actual del alimento
     * @param recipiente     tipo de recipiente que contiene el alimento
     * @param esrefrigerable {@code true} si puede refrigerarse
     * @param peso           peso del alimento
     * @param proveedor      nombre del proveedor
     * @param anosVida       años de vida útil del alimento
     * @param tipoEmpaque    tipo de empaque utilizado
     */
    public NoPerecedero(String nombre, int codigo, String fecha, String tamano,
                        int cantidad, double costo, String estado, String recipiente,
                        boolean esrefrigerable, double peso, String proveedor,
                        int anosVida, String tipoEmpaque) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado,
              recipiente, esrefrigerable, peso, proveedor);
        this.anosVida = anosVida;
        this.tipoEmpaque = tipoEmpaque;
    }

    /**
     * Retorna los años de vida útil del alimento.
     *
     * @return años de vida como {@code int}
     */
    public int    getAnosVida()   { return anosVida; }

    /**
     * Retorna el tipo de empaque del alimento.
     *
     * @return tipo de empaque como {@code String}
     */
    public String getTipoEmpaque(){ return tipoEmpaque; }

    /**
     * Establece los años de vida útil del alimento.
     *
     * @param a nuevos años de vida como {@code int}
     */
    public void setAnosVida(int a)        { this.anosVida = a; }

    /**
     * Establece el tipo de empaque del alimento.
     *
     * @param t nuevo tipo de empaque como {@code String}
     */
    public void setTipoEmpaque(String t)  { this.tipoEmpaque = t; }

    /**
     * Calcula la durabilidad del alimento no perecedero indicando sus años
     * de vida útil y el tipo de empaque.
     *
     * @param vence fecha o referencia de vencimiento a evaluar
     * @return descripción de la durabilidad como {@code String}
     */
    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad es de " + anosVida +
               " anos, en un empaque de " + tipoEmpaque;
    }

    /**
     * Retorna una descripción detallada del alimento no perecedero,
     * incluyendo su nombre, años de vida y tipo de empaque.
     *
     * @return descripción del alimento como {@code String}
     */
    @Override
    public String describir() {
        return "[NoPerecedero] " + getNombre() +
               " | Vida: " + anosVida + " anos" +
               " | Empaque: " + tipoEmpaque;
    }

    /**
     * Retorna una representación en cadena del objeto {@code NoPerecedero},
     * incluyendo sus atributos propios y los heredados de {@code Alimento}.
     *
     * @return representación textual del objeto {@code NoPerecedero}
     */
    @Override
    public String toString() {
        return "NoPerecedero{anosVida=" + anosVida +
               ", tipoEmpaque='" + tipoEmpaque +
               "', " + super.toString() + "}";
    }
}
