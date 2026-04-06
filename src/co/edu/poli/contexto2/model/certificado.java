package co.edu.poli.contexto2.model;

/**
 * Representa un certificado identificado por un número único.
 * <p>
 * Esta clase es {@code final} y, por lo tanto, no puede ser heredada por ninguna otra clase.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * certificado cert = new certificado("CERT-001");
 * System.out.println(cert.getNumero()); // CERT-001
 * }</pre>
 */
// __Clase__ __que__ no __se__ __puede__ __heredar__
public final class certificado {

    /** Número identificador del certificado. */
    private String numero;

    /**
     * Crea una nueva instancia de {@code certificado} con el número especificado.
     *
     * @param numero el número identificador del certificado; no debe ser {@code null}
     */
    public certificado(String numero) {
        this.numero = numero;
    }

    /**
     * Retorna el número identificador del certificado.
     *
     * @return el número del certificado como {@code String}
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Retorna una representación en cadena del certificado.
     * <p>
     * El formato es: {@code Certificado{numero='<valor>'}}.
     * </p>
     *
     * @return representación textual del objeto {@code certificado}
     */
    @Override
    public String toString() {
        return "Certificado{numero='" + numero + "'}";
    }
}