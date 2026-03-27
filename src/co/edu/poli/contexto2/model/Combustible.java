package co.edu.poli.contexto2.model;

public class Combustible {
    private String tipo;
    private String marca;
    private String fecha;
    private boolean esinflamable;
    private boolean esrenovable;
    private boolean escorrosivo;
    private boolean escontaminante;
    private double cantidad;
    private String serial;
    
    // Constructor sobrecargado
    public Combustible(String tipo, String marca, String fecha, 
                       boolean esinflamable, boolean esrenovable, boolean escorrosivo, 
                       boolean escontaminante, double cantidad, String serial) {
        this.tipo = tipo;
        this.marca = marca;
        this.fecha = fecha;
        this.esinflamable = esinflamable;
        this.esrenovable = esrenovable;
        this.escorrosivo = escorrosivo;
        this.escontaminante = escontaminante;
        this.cantidad = cantidad;
        this.serial = serial;
    }
    
    // Getters
    public String getTipo() {
        return tipo;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public boolean isEsinflamable() {
        return esinflamable;
    }
    
    public boolean isEsrenovable() {
        return esrenovable;
    }
    
    public boolean isEscorrosivo() {
        return escorrosivo;
    }
    
    public boolean isEscontaminante() {
        return escontaminante;
    }
    
    public double getCantidad() {
        return cantidad;
    }
    
    public String getSerial() {
        return serial;
    }
    
    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setEsinflamable(boolean esinflamable) {
        this.esinflamable = esinflamable;
    }
    
    public void setEsrenovable(boolean esrenovable) {
        this.esrenovable = esrenovable;
    }
    
    public void setEscorrosivo(boolean escorrosivo) {
        this.escorrosivo = escorrosivo;
    }
    
    public void setEscontaminante(boolean escontaminante) {
        this.escontaminante = escontaminante;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        return "Combustible{" +
                "tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", fecha='" + fecha + '\'' +
                ", esinflamable=" + esinflamable +
                ", esrenovable=" + esrenovable +
                ", escorrosivo=" + escorrosivo +
                ", escontaminante=" + escontaminante +
                ", cantidad=" + cantidad +
                ", serial='" + serial + '\'' +
                '}';
    }
    
    // Metodos adicionales del diagrama
    public boolean calcularconfiabilidad(boolean octable) {
        return false; 
    }
    
    public boolean calcularcaducidad(String inventario) {
        return false;
    }
}