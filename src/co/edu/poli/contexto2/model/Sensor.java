package co.edu.poli.contexto2.model;

public class Sensor {
    private boolean sensible;
    private boolean espreciso;
    private boolean calibrado;
    private boolean automatico;
    private String codigo;
    
    // Constructor sobrecargado
    public Sensor(boolean sensible, boolean espreciso, boolean calibrado, 
                  boolean automatico, String codigo) {
        this.sensible = sensible;
        this.espreciso = espreciso;
        this.calibrado = calibrado;
        this.automatico = automatico;
        this.codigo = codigo;
    }
    
    // Getters
    public boolean isSensible() {
        return sensible;
    }
    
    public boolean isEspreciso() {
        return espreciso;
    }
    
    public boolean isCalibrado() {
        return calibrado;
    }
    
    public boolean isAutomatico() {
        return automatico;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    // Setters
    public void setSensible(boolean sensible) {
        this.sensible = sensible;
    }
    
    public void setEspreciso(boolean espreciso) {
        this.espreciso = espreciso;
    }
    
    public void setCalibrado(boolean calibrado) {
        this.calibrado = calibrado;
    }
    
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Sensor{" +
                "sensible=" + sensible +
                ", espreciso=" + espreciso +
                ", calibrado=" + calibrado +
                ", automatico=" + automatico +
                ", codigo='" + codigo + '\'' +
                '}';
    }
    
    // Método adicional del diagrama
    public String verificarestado(String gusto) {
        return ""; 
    }
}