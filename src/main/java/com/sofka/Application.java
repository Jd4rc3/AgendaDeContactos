package com.sofka;

import lombok.extern.log4j.Log4j2;

import static com.sofka.utilidades.Util.askFor;

/**
 * Application main class.
 */
@Log4j2
public class Application {
    public static void main(final String[] args) {
        var menu = new MenuPrincipal();

        Agenda agenda = new Agenda();

        menu.mostrar(agenda);
    }
}
