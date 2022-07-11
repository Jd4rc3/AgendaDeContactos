package com.sofka;

import java.util.ArrayList;
import java.util.List;

import static com.sofka.utilidades.Util.askFor;
import static com.sofka.utilidades.Util.menuMaker;

public class MenuPrincipal {

    int selection;

    public MenuPrincipal() {
    }

    public Contacto resultados(List<Contacto> contactos) {
        ArrayList<String> opciones = new ArrayList<>();

        for (Contacto c : contactos) {
            opciones.add(String.format("%s %s", c.getNombre(), c.getTelefono()));
        }

        if (opciones.size() == 0) {
            System.out.println("No se encontraron resultados");
            return null;
        }

        int choice = menuMaker("", opciones.toArray(new String[0])) - 1;

        return contactos.get(choice);
    }

    private void modificar(Contacto contacto, Agenda agenda) {
        if (contacto == null) {
            return;
        }

        selection = menuMaker("", new String[]{"Modificar contacto", "Eliminar contacto",
                "Volver al " + "menu " + "pincipal"});

        switch (selection) {
            case 1:
                agenda.modificar(contacto);
                break;
            case 2:
                agenda.eliminarContacto(contacto);
            case 3:
                mostrar(agenda);
        }
    }

    private Contacto buscar(Agenda agenda) {
        selection = menuMaker("",
                              new String[]{"Buscar por nombre", "Buscar numero de telefono",
                                      "Volver al menu principal"});

        switch (selection) {
            case 1:
                return resultados(agenda.buscarPorNombre(askFor("nombre", false)));
            case 2:
                return resultados(agenda.buscarPorNumero(askFor("telefono", true)));
            case 3:
                mostrar(agenda);
        }

        return null;
    }

    public void mostrar(Agenda agenda) {
        selection = menuMaker("Bienvenido al menu principal, realice su seleccion",
                              new String[]{"Mostrar contactos", "Nuevo contacto",
                                      "Buscar " + "contacto", "Salir de la agenda"});

        switch (selection) {
            case 1:
                agenda.mostrarContactos();
                break;
            case 2:
                agenda.agregarContacto();
                break;
            case 3:
                modificar(buscar(agenda), agenda);
                break;
            case 4:
                System.exit(0);
        }
        mostrar(agenda);
    }
}
