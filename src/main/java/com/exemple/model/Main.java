package com.exemple.model;

import com.exemple.model.Cotxe;
import com.exemple.model.Motor;
import com.exemple.model.Moto;
import com.exemple.model.Vehicle;
import com.exemple.utils.CalculadoraKilometres;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal que demostra l'ús del sistema de vehicles.
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            // Crear motors
            Motor motorGasolina = new Motor(120, "Gasolina", 4);
            Motor motorDiesel = new Motor(150, "Diesel", 6);
            Motor motorElectric = new Motor(200, "Electric", 0);
            
            // Crear cotxes amb diferents motors
            Cotxe cotxeSeat = new Cotxe("Seat", "Leon", 2020, motorGasolina, 5, false);
            Cotxe cotxeVolvo = new Cotxe("Volvo", "XC60", 2019, motorDiesel, 5, true);
            Cotxe cotxeTesla = new Cotxe("Tesla", "Model 3", 2023, motorElectric, 4, true);
            
            // Crear motos de diferents tipus
            Moto motoHonda = new Moto("Honda", "CBR650R", 2021, 650, "Esportiva");
            Moto motoBMW = new Moto("BMW", "R1250GS", 2020, 1250, "Trail");
            
            // Afegir quilòmetres als vehicles
            cotxeSeat.afegirKilometres(45000);
            cotxeVolvo.afegirKilometres(78000);
            cotxeTesla.afegirKilometres(15000);
            motoHonda.afegirKilometres(12000);
            motoBMW.afegirKilometres(36000);
            
            // Llista de vehicles per treballar amb ells de forma genèrica
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(cotxeSeat);
            vehicles.add(cotxeVolvo);
            vehicles.add(cotxeTesla);
            vehicles.add(motoHonda);
            vehicles.add(motoBMW);
            
            // Mostrar informació de tots els vehicles
            System.out.println("INFORMACIÓ DELS VEHICLES:");
            System.out.println("========================\n");
            
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.toString());
                System.out.println("Velocitat màxima: " + vehicle.getVelocitatMaxima() + " km/h");
                System.out.println("Edat: " + vehicle.getEdat() + " anys");
                
                // Utilitzar polimorfisme per obtenir el consum
                if (vehicle instanceof Cotxe) {
                    Cotxe cotxe = (Cotxe) vehicle;
                    System.out.println("Consum: " + cotxe.getConsum() + (cotxe.getMotor().getTipus().equals("Electric") ? " kWh/100km" : " L/100km"));
                } else if (vehicle instanceof Moto) {
                    Moto moto = (Moto) vehicle;
                    System.out.println("Consum: " + moto.getConsum() + " L/100km");
                }
                
                System.out.println("------------------------");
            }
            
            // Utilitzar la calculadora de quilòmetres
            System.out.println("\nANÀLISI DE QUILOMETRATGE:");
            System.out.println("======================\n");
            
            for (Vehicle vehicle : vehicles) {
                try {
                    double mitjanaKmAny = CalculadoraKilometres.calcularMitjanaKmAny(vehicle);
                    System.out.println(vehicle.getMarca() + " " + vehicle.getModel() + ":");
                    System.out.println("- Mitjana anual: " + String.format("%.2f", mitjanaKmAny) + " km/any");
                    System.out.println("- És vehicle nou? " + (CalculadoraKilometres.esVehicleNou(vehicle) ? "Sí" : "No"));
                    
                    // Calcular anys per arribar a 100.000 km
                    try {
                        if (vehicle.getQuilometres() < 100000) {
                            int anysObjectiu = CalculadoraKilometres.anysPerAssolirQuilometratge(vehicle, 100000);
                            System.out.println("- Anys per arribar a 100.000 km: " + anysObjectiu);
                        } else {
                            System.out.println("- Ja ha superat els 100.000 km");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("- No es pot calcular els anys per arribar a 100.000 km: " + e.getMessage());
                    }
                    
                    System.out.println("------------------------");
                } catch (IllegalArgumentException e) {
                    System.out.println(vehicle.getMarca() + " " + vehicle.getModel() + ": Error - " + e.getMessage());
                    System.out.println("------------------------");
                }
            }
            
            // Exemple de com actualitzar la informació d'un vehicle
            System.out.println("\nACTUALITZACIÓ DE VEHICLE:");
            System.out.println("======================\n");
            
            System.out.println("Vehicle abans de l'actualització:");
            System.out.println(cotxeSeat.toString());
            
            // Canviar el motor del cotxe
            Motor motorNou = new Motor(140, "Gasolina", 4);
            cotxeSeat.setMotor(motorNou);
            
            // Afegir més quilòmetres
            cotxeSeat.afegirKilometres(5000);
            
            System.out.println("\nVehicle després de l'actualització:");
            System.out.println(cotxeSeat.toString());
            System.out.println("Nova velocitat màxima: " + cotxeSeat.getVelocitatMaxima() + " km/h");
            System.out.println("Nou consum: " + cotxeSeat.getConsum() + " L/100km");
            
        } catch (Exception e) {
            System.err.println("Error en l'execució del programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}