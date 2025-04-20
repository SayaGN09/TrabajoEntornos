package com.exemple.model;

/**
 * Classe que representa una motocicleta.
 * Hereta de Vehicle.
 * 
 * 
 * @version 1.0
 */
public class Moto extends Vehicle {
    
    private int cilindrada;
    private String tipus; // "Esportiva", "Turisme", "Trail", "Scooter"
    
    /**
     * Constructor que inicialitza una moto.
     * 
     * @param marca La marca de la moto
     * @param model El model de la moto
     * @param anyFabricacio L'any de fabricació
     * @param cilindrada La cilindrada en cc
     * @param tipus El tipus de moto
     */
    public Moto(String marca, String model, int anyFabricacio, int cilindrada, String tipus) {
        super(marca, model, anyFabricacio);
        this.cilindrada = cilindrada;
        this.tipus = tipus;
    }
    
    /**
     * Implementació del mètode abstracte per calcular velocitat màxima.
     * 
     * @return La velocitat màxima en km/h
     */
    @Override
    public int getVelocitatMaxima() {
        // La velocitat màxima depèn de la cilindrada i del tipus
        int base = 80 + (cilindrada / 10);
        
        if (tipus.equalsIgnoreCase("Esportiva")) {
            return base + 50;
        } else if (tipus.equalsIgnoreCase("Turisme")) {
            return base + 20;
        } else if (tipus.equalsIgnoreCase("Trail")) {
            return base + 10;
        } else {
            return base;
        }
    }
    
    /**
     * Calcula el consum de la moto.
     * 
     * @return El consum en litres/100km
     */
    public double getConsum() {
        return 2.0 + (cilindrada / 1000.0);
    }
    
    /**
     * Retorna una descripció completa de la moto.
     * 
     * @return Una cadena amb totes les dades de la moto
     */
    @Override
    public String toString() {
        return super.toString() + " - " + cilindrada + " cc - " + tipus;
    }
    
    // Getters i setters
    
    /**
     * Obté la cilindrada de la moto.
     * 
     * @return La cilindrada en cc
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
    /**
     * Estableix la cilindrada de la moto.
     * 
     * @param cilindrada La cilindrada en cc
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    /**
     * Obté el tipus de moto.
     * 
     * @return El tipus de moto
     */
    public String getTipus() {
        return tipus;
    }
    
    /**
     * Estableix el tipus de moto.
     * 
     * @param tipus El tipus de moto
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}