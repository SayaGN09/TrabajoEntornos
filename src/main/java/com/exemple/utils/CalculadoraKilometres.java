package com.exemple.utils;

import com.exemple.model.Vehicle;

/**
 * Classe utilitària per realitzar càlculs amb vehicles.
 * 
 *
 * @version 1.0
 */
public class CalculadoraKilometres {
    
    /**
     * Calcula la mitjana de quilòmetres per any del vehicle.
     * 
     * @param vehicle El vehicle a calcular
     * @return La mitjana de quilòmetres per any
     * @throws IllegalArgumentException Si el vehicle és null o l'edat és 0
     */
    public static double calcularMitjanaKmAny(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehicle no pot ser null");
        }
        
        int edat = vehicle.getEdat();
        
        if (edat == 0) {
            throw new IllegalArgumentException("El vehicle ha de tenir almenys 1 any d'antiguitat");
        }
        
        return (double) vehicle.getQuilometres() / edat;
    }
    
    /**
     * Comprova si un vehicle es pot considerar "nou" (menys de 10.000 km).
     * 
     * @param vehicle El vehicle a comprovar
     * @return true si és nou, false en cas contrari
     * @throws IllegalArgumentException Si el vehicle és null
     */
    public static boolean esVehicleNou(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehicle no pot ser null");
        }
        
        return vehicle.getQuilometres() < 10000;
    }
    
    /**
     * Calcula quants anys tardarà un vehicle a superar un determinat quilometratge
     * basant-se en la seva mitjana actual de quilòmetres per any.
     * 
     * @param vehicle El vehicle a calcular
     * @param quilometratgeObjectiu El quilometratge objectiu
     * @return Els anys que tardarà a assolir l'objectiu
     * @throws IllegalArgumentException Si el vehicle és null o el quilometratge objectiu és invàlid
     */
    public static int anysPerAssolirQuilometratge(Vehicle vehicle, int quilometratgeObjectiu) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehicle no pot ser null");
        }
        
        if (quilometratgeObjectiu <= vehicle.getQuilometres()) {
            throw new IllegalArgumentException("El quilometratge objectiu ha de ser superior a l'actual");
        }
        
        double mitjanaAnual = calcularMitjanaKmAny(vehicle);
        
        if (mitjanaAnual <= 0) {
            throw new IllegalArgumentException("La mitjana anual de quilòmetres ha de ser positiva");
        }
        
        int quilometresRestants = quilometratgeObjectiu - vehicle.getQuilometres();
        return (int) Math.ceil(quilometresRestants / mitjanaAnual);
    }
}