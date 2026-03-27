package co.edu.poli.contexto2.model;

public class Perecedero extends Alimento {
    private int diasVencimiento;
    private String tipoConservacion;

    public Perecedero(String nombre, int codigo, String fecha, String tamano,
                      int cantidad, double costo, String estado, String recipiente,
                      boolean esrefrigerable, double peso, String proveedor,
                      int diasVencimiento, String tipoConservacion) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado,
              recipiente, esrefrigerable, peso, proveedor);
        this.diasVencimiento = diasVencimiento;
        this.tipoConservacion = tipoConservacion;
    }

    public int    getDiasVencimiento()  { return diasVencimiento; }
    public String getTipoConservacion() { return tipoConservacion; }
    public void setDiasVencimiento(int d)         { this.diasVencimiento = d; }
    public void setTipoConservacion(String t)     { this.tipoConservacion = t; }

    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad es de " + diasVencimiento +
               " dias, conservacion: " + tipoConservacion;
    }

    @Override
    public String describir() {
        return "[Perecedero] " + getNombre() +
               " | Vence en " + diasVencimiento + " dias" +
               " | Conservacion: " + tipoConservacion;
    }

    @Override
    public String toString() {
        return "Perecedero{diasVencimiento=" + diasVencimiento +
               ", tipoConservacion='" + tipoConservacion +
               "', " + super.toString() + "}";
    }
}