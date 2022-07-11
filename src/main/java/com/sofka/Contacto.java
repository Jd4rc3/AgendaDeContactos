package com.sofka;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contacto {
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;

    public Contacto(int id, String nombre, String email, String telefono) {
        this.id       = id;
        this.nombre   = nombre;
        this.email    = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("%-20s %10s %s", nombre, telefono, email);
    }
}
