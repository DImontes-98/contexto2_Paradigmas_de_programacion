package co.edu.poli.contexto2.model;

public class Nave {
    private String nombre;
    private int codigo;
    private String tamano;
    private String material;
    private String fecha;
    private double capacidad;
    private double autonomia;
    private double peso;
    private String marca;
    private Combustible combustible;
    private double motor;
    private Contenedor[] contenedor;
    
    // Constructor sobrecargado
    public Nave(String nombre, int codigo, String tamano, String material, String fecha,
                double capacidad, double autonomia, double peso, String marca, 
                Combustible combustible, double motor, Contenedor[] contenedor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tamano = tamano;
        this.material = material;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.autonomia = autonomia;
        this.peso = peso;
        this.marca = marca;
        this.combustible = combustible;
        this.motor = motor;
        this.contenedor = contenedor;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getTamano() {
        return tamano;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public double getCapacidad() {
        return capacidad;
    }
    
    public double getAutonomia() {
        return autonomia;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public Combustible getCombustible() {
        return combustible;
    }
    
    public double getMotor() {
        return motor;
    }
    
    public Contenedor[] getContenedor() {
        return contenedor;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
    
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    
    public void setMotor(double motor) {
        this.motor = motor;
    }
    
    public void setContenedor(Contenedor[] contenedor) {
        this.contenedor = contenedor;
    }
    
    // Metodo toString
    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", tamano='" + tamano + '\'' +
                ", material='" + material + '\'' +
                ", fecha='" + fecha + '\'' +
                ", capacidad=" + capacidad +
                ", autonomia=" + autonomia +
                ", peso=" + peso +
                ", marca='" + marca + '\'' +
                ", combustible=" + combustible +
                ", motor=" + motor +
                ", contenedor=" + java.util.Arrays.toString(contenedor) +
                '}';
    }
    
    // Metodo adicional del diagrama
    public double calcularconsumo(double distancia) {
        return 0.0;
    }
}