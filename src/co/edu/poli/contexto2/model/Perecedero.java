package co.edu.poli.contexto2.model;

public class Perecedero extends Alimento {
    private int diasVencimiento;
    private String tipoConservacion;

    // Constructor sobrecargado
    public Perecedero(String nombre, int codigo, String fecha, String tamano,
                      int cantidad, double costo, String estado, String recipiente,
                      boolean esrefrigerable, double peso, String proveedor,
                      int diasVencimiento, String tipoConservacion) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado, recipiente, esrefrigerable, peso, proveedor);
        this.diasVencimiento = diasVencimiento;
        this.tipoConservacion = tipoConservacion;
    }

    // Getters
    public int getDiasVencimiento() {
        return diasVencimiento;
    }

    public String getTipoConservacion() {
        return tipoConservacion;
    }

    // Setters
    public void setDiasVencimiento(int diasVencimiento) {
        this.diasVencimiento = diasVencimiento;
    }

    public void setTipoConservacion(String tipoConservacion) {
        this.tipoConservacion = tipoConservacion;
    }

    // Método propio del diagrama IMPORTANTE aca me toca cambiar y sobreescribir en este lado
    @Override
    public String calcularDurabilidad(String vence) {
    	// TODO Auto-generated method stub
    	return "La durabilidad es de " + diasVencimiento + " dias, conservacion: " + tipoConservacion;
    }

    // Método toString
    @Override
    public String toString() {
        return "Perecedero{" +
                "diasVencimiento=" + diasVencimiento +
                ", tipoConservacion='" + tipoConservacion + '\'' +
                ", " + super.toString() +
                '}';
    }
}