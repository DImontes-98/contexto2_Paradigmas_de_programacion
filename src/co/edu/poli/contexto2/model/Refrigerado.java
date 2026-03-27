package co.edu.poli.contexto2.model;

public class Refrigerado extends Perecedero {
    private double temperaturaMinima;
    private String tipoRefrigeracion;
    private static int totalRefrigerados;

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

    public double getTemperaturaMinima()  { return temperaturaMinima; }
    public String getTipoRefrigeracion()  { return tipoRefrigeracion; }
    public static int getTotalRefrigerados() { return totalRefrigerados; }
    public void setTemperaturaMinima(double t) { this.temperaturaMinima = t; }
    public void setTipoRefrigeracion(String t) { this.tipoRefrigeracion = t; }
    public static void setTotalRefrigerados(int t) { totalRefrigerados = t; }

    public static int obtenerTotalRefrigerados() { return totalRefrigerados; }

    @Override
    public String calcularDurabilidad(String vence) {
        return "La durabilidad refrigerada con " + tipoRefrigeracion +
               " a " + temperaturaMinima + " C: " +
               getDiasVencimiento() + " dias";
    }

    /** Implementacion del metodo abstracto de Alimento */
    @Override
    public String describir() {
        return "[Refrigerado] " + getNombre() +
               " | Temp. mín: " + temperaturaMinima + "°C" +
               " | Refrigeración: " + tipoRefrigeracion +
               " | Vence en: " + getDiasVencimiento() + " dias";
    }

    @Override
    public String toString() {
        return "Refrigerado{temperaturaMinima=" + temperaturaMinima +
               ", tipoRefrigeracion='" + tipoRefrigeracion +
               "', totalRefrigerados=" + totalRefrigerados +
               ", " + super.toString() + "}";
    }
}
