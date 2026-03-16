package co.edu.poli.contexto2.model;

// Clase que no se puede heredar
public final class certificado {
    private String numero;
    
    public certificado(String numero) {
        this.numero = numero;
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return "Certificado{numero='" + numero + "'}";
    }
}