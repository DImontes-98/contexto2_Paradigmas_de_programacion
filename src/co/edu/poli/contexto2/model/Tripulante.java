package co.edu.poli.contexto2.model;

public class Tripulante {
    private String nombre;
    private String fecha;
    private String codigo;
    private int cantidad;
    private String estado;
    private boolean entrenado;
    private double peso;
    
    // Constructor sobrecargado
    public Tripulante(String nombre, String fecha, String codigo, int cantidad, 
                      String estado, boolean entrenado, double peso) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.estado = estado;
        this.entrenado = entrenado;
        this.peso = peso;
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
    
    public String getEstado() {
        return estado;
    }
    
    public boolean isEntrenado() {
        return entrenado;
    }
    
    public double getPeso() {
        return peso;
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
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setEntrenado(boolean entrenado) {
        this.entrenado = entrenado;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Tripulante{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", entrenado=" + entrenado +
                ", peso=" + peso +
                '}';
    }
    
    // Método adicional del diagrama
    public String verificarsalud(String adaptabilidad) {
        return "";
    }
}