package com.sofka;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sofka.utilidades.Util.askFor;


public class Agenda {
    private final ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();

        contactos.add(new Contacto(1, "Lily", "Lily. @yopmail.com", "3142152440"));
        contactos.add(new Contacto(2, "Karly", "Karly.@yopmail.com", "3750231913"));
        contactos.add(new Contacto(3, "Jacquetta", "Jacquetta.@yopmail.com", "3237280314"));
        contactos.add(new Contacto(4, "Heddie", "Heddie.@yopmail.com", "3470355888"));
        contactos.add(new Contacto(5, "Stacey", "Stacey.@yopmail.com", "3916063602"));
    }

    public void agregarContacto() {
        String nombre = askFor("nombre", false);
        String telefono = askFor("telefono", true);
        String email = askFor("email", false);

        contactos.add(new Contacto(contactos.size() + 1, nombre, email, telefono));

        System.out.println("Contacto agregado");
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
        System.out.println("Contacto eliminado");
    }

    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public List<Contacto> buscarPorNombre(String nombre) {
        String regex = "^.*(" + nombre + ")+\\s*.*";
        ArrayList<Contacto> encontrados = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        ArrayList<Matcher> matchers = new ArrayList<>();

        for (Contacto contacto : contactos) {
            matchers.add(pattern.matcher(contacto.getNombre()));
        }

        for (int i = 0; i < matchers.size(); i++) {
            var m = matchers.get(i);
            if (m.matches()) {
                encontrados.add(contactos.get(i));
            }
        }

        return encontrados;
    }

    public List<Contacto> buscarPorNumero(String numero) {
        String regex = "\\d*" + numero + "\\d*";

        ArrayList<Contacto> encontrados = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        ArrayList<Matcher> matchers = new ArrayList<>();

        for (Contacto contacto : contactos) {
            matchers.add(pattern.matcher(contacto.getTelefono()));
        }

        for (int i = 0; i < matchers.size(); i++) {
            var m = matchers.get(i);
            if (m.matches()) {
                encontrados.add(contactos.get(i));
            }
        }

        return encontrados;
    }

    public void modificar(Contacto contacto) {
        int index = contactos.indexOf(contacto);

        String nombre = askFor("nombre", false);
        String telefono = askFor("telefono", true);
        String email = askFor("email", false);

        contactos.set(index, new Contacto(contacto.getId(), nombre, telefono, email));
    }
}
