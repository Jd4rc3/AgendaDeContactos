package com.sofka.utilidades;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

@Log4j2
public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static int menuMaker(String title, String[] options) {
        int counter = 1;

        while (true) {
            try {
                log.info("" + title);

                for (String option : options) {
                    log.info(String.format("%d. %s", counter++, option));
                }

                int seleccion = Integer.parseInt(scanner.next());

                if (seleccion > options.length || seleccion <= 0) {
                    throw new InputMismatchException();
                }

                return seleccion;

            } catch (InputMismatchException | NumberFormatException e) {
                counter = 1;

                if (e instanceof InputMismatchException) {
                    log.info("Seleccion invalida, digite un numero entre 1 y " + options.length);
                } else {
                    log.info("Seleccion invalida, intente de nuevo");
                }
            }
        }
    }

    public static String askFor(String value, boolean isNumber) {
        String checkedValue;

        while (true) {
            try {
                log.info("Por favor digite " + value + " -> ");

                checkedValue = scanner.next();

                if (isNumber) {
                    Long.parseLong(checkedValue);
                }

                if (checkedValue.trim().isEmpty()) {
                    throw new InputMismatchException();
                }

                return checkedValue;
            } catch (InputMismatchException | NumberFormatException e) {
                if (e instanceof InputMismatchException) {
                    log.info("Digite un valor");
                } else {
                    log.info("Digite un numero valido");
                }
            }
        }
    }

    public static void ejecutarConsulta(Connection con) {
        try {
            String SQL = "SELECT * FROM table_name";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                log.info(rs.getString("columna") + ", " + rs.getString("columna"));
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public List<Contacto> buscarPorNombre(String nombre) {
//        String regex = "^.*(" + nombre + ")+\\s*.*";
//        ArrayList<Contacto> encontrados = new ArrayList<>();
//
//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        ArrayList<Matcher> matchers = new ArrayList<>();
//
//        for (Contacto contacto : contactos) {
//            matchers.add(pattern.matcher(contacto.getNombre()));
//        }
//
//        for (int i = 0; i < matchers.size(); i++) {
//            var m = matchers.get(i);
//            if (m.matches()) {
//                encontrados.add(contactos.get(i));
//            }
//        }
//
//        return encontrados;
//    }
//
//    public List<Contacto> buscarPorNumero(String numero) {
//        String regex = "\\d*" + numero + "\\d*";
//
//        ArrayList<Contacto> encontrados = new ArrayList<>();
//
//        Pattern pattern = Pattern.compile(regex);
//        ArrayList<Matcher> matchers = new ArrayList<>();
//
//        for (Contacto contacto : contactos) {
//            matchers.add(pattern.matcher(contacto.getTelefono()));
//        }
//
//        for (int i = 0; i < matchers.size(); i++) {
//            var m = matchers.get(i);
//            if (m.matches()) {
//                encontrados.add(contactos.get(i));
//            }
//        }
//
//        return encontrados;
//    }
}





