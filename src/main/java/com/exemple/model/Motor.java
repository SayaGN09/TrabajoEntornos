package com.exemple.model;

/**
 * Classe que representa un motor de vehicle.
 * Exemple de composició amb la classe Cotxe.
 * 
 * 
 * @version 1.0
 */
public class Motor {
    
    private int potencia;
    private String tipus; // "Gasolina", "Diesel", "Electric"
    private int cilindres;
    
    /**
     * Constructor que inicialitza un motor.
     * 
     * @param potencia La potència en CV
     * @param tipus El tipus de motor
     * @param cilindres El nombre de cilindres
     */
    public Motor(int potencia, String tipus, int cilindres) {
        this.potencia = potencia;
        this.tipus = tipus;
        this.cilindres = cilindres;
    }
    
    /**
     * Calcula el consum estimat del motor.
     * 
     * @return El consum en litres per 100km (o kWh per 100km si és elèctric)
     */
    public double calcularConsum() {
        if (tipus.equalsIgnoreCase("Electric")) {
            return potencia * 0.05;
        } else if (tipus.equalsIgnoreCase("Diesel")) {
            return 5 + (potencia * 0.01);
        } else {
            return 6 + (potencia * 0.015);
        }
    }
    
    /**
     * Retorna una descripció del motor.
     * 
     * @return Una cadena amb les dades del motor
     */
    @Override
    public String toString() {
        return "Motor " + tipus + " de " + potencia + " CV i " + cilindres + " cilindres";
    }
    
    // Getters i setters
    
    /**
     * Obté la potència del motor.
     * 
     * @return La potència en CV
     */
    public int getPotencia() {
        return potencia;
    }
    
    /**
     * Estableix la potència del motor.
     * 
     * @param potencia La potència en CV
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    /**
     * Obté el tipus de motor.
     * 
     * @return El tipus de motor
     */
    public String getTipus() {
        return tipus;
    }
    
    /**
     * Estableix el tipus de motor.
     * 
     * @param tipus El tipus de motor
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    /**
     * Obté el nombre de cilindres.
     * 
     * @return El nombre de cilindres
     */
    public int getCilindres() {
        return cilindres;
    }
    
    /**
     * Estableix el nombre de cilindres.
     * 
     * @param cilindres El nombre de cilindres
     */
    public void setCilindres(int cilindres) {
        this.cilindres = cilindres;
    }
}