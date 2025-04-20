package com.exemple.model;

/**
 * Classe que representa un cotxe.
 * Hereta de Vehicle i té una relació de composició amb Motor.
 * 
 * 
 * @version 1.0
 */
public class Cotxe extends Vehicle {
    
    private Motor motor;
    private int portes;
    private boolean automatico;
    
    /**
     * Constructor que inicialitza un cotxe.
     * 
     * @param marca La marca del cotxe
     * @param model El model del cotxe
     * @param anyFabricacio L'any de fabricació
     * @param motor El motor del cotxe
     * @param portes El nombre de portes
     * @param automatico Indica si té transmissió automàtica
     */
    public Cotxe(String marca, String model, int anyFabricacio, Motor motor, int portes, boolean automatico) {
        super(marca, model, anyFabricacio);
        this.motor = motor;
        this.portes = portes;
        this.automatico = automatico;
    }
    
    /**
     * Implementació del mètode abstracte per calcular velocitat màxima.
     * 
     * @return La velocitat màxima en km/h
     */
    @Override
    public int getVelocitatMaxima() {
        // La velocitat màxima depèn de la potència del motor
        return 100 + (motor.getPotencia() / 2);
    }
    
    /**
     * Calcula el consum del cotxe.
     * 
     * @return El consum en litres/100km o kWh/100km
     */
    public double getConsum() {
        return motor.calcularConsum();
    }
    
    /**
     * Retorna una descripció completa del cotxe.
     * 
     * @return Una cadena amb totes les dades del cotxe
     */
    @Override
    public String toString() {
        return super.toString() + " - " + motor.toString() + 
               " - " + portes + " portes - " + (automatico ? "Automàtic" : "Manual");
    }
    
    // Getters i setters
    
    /**
     * Obté el motor del cotxe.
     * 
     * @return El motor del cotxe
     */
    public Motor getMotor() {
        return motor;
    }
    
    /**
     * Estableix el motor del cotxe.
     * 
     * @param motor El motor a establir
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    /**
     * Obté el nombre de portes.
     * 
     * @return El nombre de portes
     */
    public int getPortes() {
        return portes;
    }
    
    /**
     * Estableix el nombre de portes.
     * 
     * @param portes El nombre de portes
     */
    public void setPortes(int portes) {
        this.portes = portes;
    }
    
    /**
     * Indica si el cotxe té transmissió automàtica.
     * 
     * @return true si és automàtic, false si és manual
     */
    public boolean isAutomatico() {
        return automatico;
    }
    
    /**
     * Estableix si el cotxe té transmissió automàtica.
     * 
     * @param automatico El valor a establir
     */
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }
}