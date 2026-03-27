package co.edu.poli.contexto2.model;

public class NoPerecedero extends Alimento {
    private int anosVida;
    private String tipoEmpaque;

    public NoPerecedero(String nombre, int codigo, String fecha, String tamano,
                        int cantidad, double costo, String estado, String recipiente,
                        boolean esrefrigerable, double peso, String proveedor,
                        int anosVida, String tipoEmpaque) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado,
              recipiente, esrefrigerable, peso, proveedor);
        this.anosVida = anosVida;
        this.tipoEmpaque = tipoEmpaque;
    }

    public int    getAnosVida()   { return anosVida; }
    public String getTipoEmpaque(){ return tipoEmpaque; }
    public void setAnosVida(int a)        { this.anosVida = a; }
    public void setTipoEmpaque(String t)  { this.tipoEmpaque = t; }

    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad es de " + anosVida +
               " anos, en un empaque de " + tipoEmpaque;
    }

    @Override
    public String describir() {
        return "[NoPerecedero] " + getNombre() +
               " | Vida: " + anosVida + " anos" +
               " | Empaque: " + tipoEmpaque;
    }

    @Override
    public String toString() {
        return "NoPerecedero{anosVida=" + anosVida +
               ", tipoEmpaque='" + tipoEmpaque +
               "', " + super.toString() + "}";
    }
}
