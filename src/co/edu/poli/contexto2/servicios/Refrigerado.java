package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Perecedero;

public class Refrigerado extends Perecedero {
    private double temperaturaMinima;
    private String tipoRefrigeracion;
    private static int totalRefrigerados;

    // Constructor sobrecargado
    public Refrigerado(String nombre, int codigo, String fecha, String tamano,
                       int cantidad, double costo, String estado, String recipiente,
                       boolean esrefrigerable, double peso, String proveedor,
                       int diasVencimiento, String tipoConservacion,
                       double temperaturaMinima, String tipoRefrigeracion) {
        super(nombre, codigo, fecha, tamano, cantidad, costo, estado, recipiente,
              esrefrigerable, peso, proveedor, diasVencimiento, tipoConservacion);
        this.temperaturaMinima = temperaturaMinima;
        this.tipoRefrigeracion = tipoRefrigeracion;
    }

    // Getters
    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public String getTipoRefrigeracion() {
        return tipoRefrigeracion;
    }

    public static int getTotalRefrigerados() {
        return totalRefrigerados;
    }

    // Setters
    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public void setTipoRefrigeracion(String tipoRefrigeracion) {
        this.tipoRefrigeracion = tipoRefrigeracion;
    }

    public static void setTotalRefrigerados(int totalRefrigerados) {
        Refrigerado.totalRefrigerados = totalRefrigerados;
    }

    // Método estático del diagrama
    public static int obtenerTotalRefrigerados() {
        return totalRefrigerados;
    }

    // Método propio del diagrama
    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad refrigerada con " + tipoRefrigeracion + " a " +
               temperaturaMinima + " C: " + getDiasVencimiento() + " dias";
    }

    // Método toString
    @Override
    public String toString() {
        return "Refrigerado{" +
                "temperaturaMinima=" + temperaturaMinima +
                ", tipoRefrigeracion='" + tipoRefrigeracion + '\'' +
                ", totalRefrigerados=" + totalRefrigerados +
                ", " + super.toString() +
                '}';
    }
}
