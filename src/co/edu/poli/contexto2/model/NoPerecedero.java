package co.edu.poli.contexto2.model;

public class NoPerecedero extends Alimento {
    private int anosVida;
    private String tipoEmpaque;

    // Constructor sobrecargado
    public NoPerecedero(String nombre, int codigo, String fecha, String tamano,
                        int cantidad, double costo, String estado, String recipiente,
                        boolean esrefrigerable, double peso, String proveedor,
                        int anosVida, String tipoEmpaque) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado, recipiente, esrefrigerable, peso, proveedor);
        this.anosVida = anosVida;
        this.tipoEmpaque = tipoEmpaque;
    }

    // Getters
    public int getAnosVida() {
        return anosVida;
    }

    public String getTipoEmpaque() {
        return tipoEmpaque;
    }

    // Setters
    public void setAnosVida(int anosVida) {
        this.anosVida = anosVida;
    }

    public void setTipoEmpaque(String tipoEmpaque) {
        this.tipoEmpaque = tipoEmpaque;
    }

    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad es de " + anosVida + " anos, en un empaque de " + tipoEmpaque;
    } 

    // Método toString
    @Override
    public String toString() {
        return "NoPerecedero{" +
                "anosVida=" + anosVida +
                ", tipoEmpaque='" + tipoEmpaque + '\'' +
                ", " + super.toString() +
                '}';
    }
}
