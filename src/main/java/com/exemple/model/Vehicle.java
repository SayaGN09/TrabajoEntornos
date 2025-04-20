package com.exemple.model;

/**
 * Classe abstracta que representa un vehicle genèric.
 * Actua com a superclasse per diferents tipus de vehicles.
 * 
 * 
 * @version 1.0
 */
public abstract class Vehicle {
    
    private String marca;
    private String model;
    private int anyFabricacio;
    protected int quilometres;
    
    /**
     * Constructor que inicialitza un vehicle.
     * 
     * @param marca La marca del vehicle
     * @param model El model del vehicle
     * @param anyFabricacio L'any de fabricació del vehicle
     */
    public Vehicle(String marca, String model, int anyFabricacio) {
        this.marca = marca;
        this.model = model;
        this.anyFabricacio = anyFabricacio;
        this.quilometres = 0;
    }
    
    /**
     * Mètode abstracte que cada subclasse ha d'implementar.
     * 
     * @return La velocitat màxima del vehicle en km/h
     */
    public abstract int getVelocitatMaxima();
    
    /**
     * Afegeix quilòmetres al comptador del vehicle.
     * 
     * @param km El nombre de quilòmetres a afegir
     */
    public void afegirKilometres(int km) {
        if (km > 0) {
            this.quilometres += km;
        }
    }
    
    /**
     * Retorna l'edat del vehicle respecte l'any actual.
     * 
     * @return L'edat del vehicle en anys
     */
    public int getEdat() {
        return 2025 - anyFabricacio;
    }
    
    /**
     * Retorna una descripció textual del vehicle.
     * 
     * @return Una cadena amb les dades bàsiques del vehicle
     */
    @Override
    public String toString() {
        return marca + " " + model + " (" + anyFabricacio + ") - " + quilometres + " km";
    }
    
    // Getters i setters
    
    /**
     * Obté la marca del vehicle.
     * 
     * @return La marca del vehicle
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Estableix la marca del vehicle.
     * 
     * @param marca La marca a establir
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obté el model del vehicle.
     * 
     * @return El model del vehicle
     */
    public String getModel() {
        return model;
    }
    
    /**
     * Estableix el model del vehicle.
     * 
     * @param model El model a establir
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     * Obté l'any de fabricació del vehicle.
     * 
     * @return L'any de fabricació
     */
    public int getAnyFabricacio() {
        return anyFabricacio;
    }
    
    /**
     * Estableix l'any de fabricació del vehicle.
     * 
     * @param anyFabricacio L'any a establir
     */
    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }
    
    /**
     * Obté el quilometratge del vehicle.
     * 
     * @return Els quilòmetres actuals
     */
    public int getQuilometres() {
        return quilometres;
    }
}