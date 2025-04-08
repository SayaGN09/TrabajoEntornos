package com.hotel;

public class Habitacion {
    private int numero;
    private boolean reservada;

    public Habitacion(int numero) {
        this.numero = numero;
        this.reservada = false;
    }

    public void reservar() {
        this.reservada = true;
    }

    public boolean estaReservada() {
        return reservada;
    }
}
