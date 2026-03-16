package co.edu.poli.contexto2.model;

public class Registro {
    private String nombre;
    private String fecha;
    private String codigo;
    private int cantidad;
    private boolean duradero;
    private Alimento[] alimento;
    private Tripulante tripulante;
    
    // Constructor sobrecargado
    public Registro(String nombre, String fecha, String codigo, int cantidad, 
                    boolean duradero, Alimento[] alimento, Tripulante tripulante) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.duradero = duradero;
        this.alimento = alimento;
        this.tripulante = tripulante;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public boolean isDuradero() {
        return duradero;
    }
    
    public Alimento[] getAlimento() {
        return alimento;
    }
    
    public Tripulante getTripulante() {
        return tripulante;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setDuradero(boolean duradero) {
        this.duradero = duradero;
    }
    
    public void setAlimento(Alimento[] alimento) {
        this.alimento = alimento;
    }
    
    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Registro{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                ", duradero=" + duradero +
                ", alimento=" + java.util.Arrays.toString(alimento) +
                ", tripulante=" + tripulante +
                '}';
    }
    
    // Método adicional del diagrama
    public String calcularresponsabilidad(String actual) {
        return ""; // Implementación básica
    }
}