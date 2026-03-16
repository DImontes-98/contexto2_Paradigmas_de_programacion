package co.edu.poli.contexto2.model;



public class Alimento {
    private String nombre;
    private int codigo;
    private String fecha;
    private String tamano;
    private int cantidad;
    private double costo;
    private String estado;
    private String recipiente;
    private boolean esrefrigerable;
    private double peso;
    private String proveedor;

    public static String tipoMoneda = "COP";
    
 // cambio 1: Atributo final que no se puede cambiar su valor
    public final String MARCA_CERTIFICADA = "INVIMA";
    
    // Constructor sobrecargado
    public Alimento(String nombre, int codigo, String fecha, String tamano, 
                    int cantidad, double costo, String estado, String recipiente, 
                    boolean esrefrigerable, double peso, String proveedor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
        this.tamano = tamano;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
        this.recipiente = recipiente;
        this.esrefrigerable = esrefrigerable;
        this.peso = peso;
        this.proveedor = proveedor;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getTamano() {
        return tamano;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getCosto() {
        return costo;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getRecipiente() {
        return recipiente;
    }
    
    public boolean isEsrefrigerable() {
        return esrefrigerable;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public String getProveedor() {
        return proveedor;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }
    
    public void setEsrefrigerable(boolean esrefrigerable) {
        this.esrefrigerable = esrefrigerable;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        return "Alimento{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", fecha='" + fecha + '\'' +
                ", tamano='" + tamano + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                ", estado='" + estado + '\'' +
                ", recipiente='" + recipiente + '\'' +
                ", esrefrigerable=" + esrefrigerable +
                ", peso=" + peso +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }
    
    // Metodos adicionales del diagrama
    public double calcularprecio() {
        return 0.0;
    }
    public String calcularDurabilidad(String vence) {
        return "";
    }
    
    public String calcularcalidaddevencimiento() {
        return "";
    }
    
 // cambio 2: Metodo final que no se puede sobrescribir
    public final String obtenerInfo() {
        return "Alimento: " + getNombre() + ", Codigo: " + getCodigo();
    }
}