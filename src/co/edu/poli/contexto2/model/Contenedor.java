package co.edu.poli.contexto2.model;

public class Contenedor {
    private String nombre;
    private int codigo;
    private double fecha;
    private String tamano;
    private int cantidad;
    private double costo;
    private String estado;
    private double peso;
    private String material;
    private String marca;
    private Sensor[] sensor;
    private Alimento[] alimento;
    
    // Constructor sobrecargado
    public Contenedor(String nombre, int codigo, double fecha, String tamano, 
                      int cantidad, double costo, String estado, double peso, 
                      String material, String marca, Sensor[] sensor, Alimento[] alimento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
        this.tamano = tamano;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
        this.peso = peso;
        this.material = material;
        this.marca = marca;
        this.sensor = sensor;
        this.alimento = alimento;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public double getFecha() {
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
    
    public double getPeso() {
        return peso;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public Sensor[] getSensor() {
        return sensor;
    }
    
    public Alimento[] getAlimento() {
        return alimento;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setFecha(double fecha) {
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
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setSensor(Sensor[] sensor) {
        this.sensor = sensor;
    }
    
    public void setAlimento(Alimento[] alimento) {
        this.alimento = alimento;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        return "Contenedor{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", fecha=" + fecha +
                ", tamano='" + tamano + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                ", estado='" + estado + '\'' +
                ", peso=" + peso +
                ", material='" + material + '\'' +
                ", marca='" + marca + '\'' +
                ", sensor=" + java.util.Arrays.toString(sensor) +
                ", alimento=" + java.util.Arrays.toString(alimento) +
                '}';
    }
    
    // Metodos adicionales del diagrama
    public double calcularcapacidad(double medida) {
        return 0.0;
    }
    
    public String calculardurabilidad(String actual) {
        return ""; 
    }
}