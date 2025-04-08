package com.hotel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HotelTest {
    @Test
    public void testAgregarHabitacion() {
        Hotel hotel = new Hotel("Gran Hotel");
        Habitacion habitacion = new Habitacion(101);
        hotel.agregarHabitacion(habitacion);
        assertFalse(habitacion.estaReservada());
    }
}