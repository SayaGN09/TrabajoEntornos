package com.exemple.utils;

import com.exemple.model.Cotxe;
import com.exemple.model.Motor;
import com.exemple.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de proves per a la classe CalculadoraKilometres.
 */
public class CalculadoraKilometresTest {
    
    private Vehicle vehicleNou;
    private Vehicle vehicleUsatPoc;
    private Vehicle vehicleUsatMolt;
    
    /**
     * Configura les dades per a les proves.
     */
    @BeforeEach
    public void setup() {
        Motor motor = new Motor(110, "Gasolina", 4);
        
        // Vehicle nou: 2023, 5000 km (2 anys, 2500 km/any)
        vehicleNou = new Cotxe("Toyota", "Corolla", 2023, motor, 5, false);
        vehicleNou.afegirKilometres(5000);
        
        // Vehicle usat poc: 2020, 30000 km (5 anys, 6000 km/any)
        vehicleUsatPoc = new Cotxe("VW", "Golf", 2020, motor, 5, true);
        vehicleUsatPoc.afegirKilometres(30000);
        
        // Vehicle usat molt: 2015, 250000 km (10 anys, 25000 km/any)
        vehicleUsatMolt = new Cotxe("Ford", "Focus", 2015, motor, 5, true);
        vehicleUsatMolt.afegirKilometres(250000);
    }
    
    /**
     * Prova el càlcul de la mitjana de quilòmetres per any.
     */
    /**
     * Prova el càlcul de la mitjana de quilòmetres per any amb valors extrems.
     */
    @Test
    @DisplayName("Test càlcul mitjana quilòmetres per any")
    public void testCalcularMitjanaKmAny() {
        // Comprovem que la mitjana del vehicle nou és 2500 km/any
        assertEquals(2500.0, CalculadoraKilometres.calcularMitjanaKmAny(vehicleNou), 0.1);
        
        // Comprovem que la mitjana del vehicle usat poc és 6000 km/any
        assertEquals(6000.0, CalculadoraKilometres.calcularMitjanaKmAny(vehicleUsatPoc), 0.1);
        
        // Comprovem que la mitjana del vehicle usat molt és 25000 km/any
        assertEquals(25000.0, CalculadoraKilometres.calcularMitjanaKmAny(vehicleUsatMolt), 0.1);
    }
    
    /**
     * Prova la comprovació de si un vehicle és nou.
     */
    @Test
    @DisplayName("Test si un vehicle és nou")
    public void testEsVehicleNou() {
        // Un vehicle amb 5000 km es considera nou
        assertTrue(CalculadoraKilometres.esVehicleNou(vehicleNou));
        
        // Un vehicle amb 30000 km no es considera nou
        assertFalse(CalculadoraKilometres.esVehicleNou(vehicleUsatPoc));
        
        // Un vehicle amb 250000 km no es considera nou
        assertFalse(CalculadoraKilometres.esVehicleNou(vehicleUsatMolt));
    }
    
    /**
     * Prova el càlcul d'anys per assolir un quilometratge objectiu.
     */
    @Test
    @DisplayName("Test anys per assolir quilometratge")
    public void testAnysPerAssolirQuilometratge() {
        // Per al vehicle nou (2500 km/any), tardarà 6 anys a arribar a 20000 km
        assertEquals(6, CalculadoraKilometres.anysPerAssolirQuilometratge(vehicleNou, 20000));
        
        // Per al vehicle usat poc (6000 km/any), tardarà 9 anys a arribar a 80000 km
        assertEquals(9, CalculadoraKilometres.anysPerAssolirQuilometratge(vehicleUsatPoc, 80000));
    }
    
    /**
     * Prova les excepcions que llança la calculadora.
     */
    @Test
    @DisplayName("Test excepcions calculadora")
    public void testExcepcions() {
        // Vehicle null llança IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraKilometres.calcularMitjanaKmAny(null);
        });
        assertTrue(exception.getMessage().contains("vehicle no pot ser null"));
        
        // Quilometratge objectiu menor que l'actual llança IllegalArgumentException
        exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraKilometres.anysPerAssolirQuilometratge(vehicleNou, 1000);
        });
        assertTrue(exception.getMessage().contains("superior a l'actual"));
    }
}