/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;

/**
 * Clase con los validadores.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Validadores {

    /**
     * Método que valida que los textos no estén vacíos.
     *
     * @param texto Cadena de texto.
     * @return Verdadero en caso de estar vacío, falso en caso contrario.
     */
    public static boolean esTextoVacio(String texto) {
        if (texto.equalsIgnoreCase("Ingrese el nombre del itinerario") || texto.equalsIgnoreCase("Ingrese la duración del itinerario") || texto.equalsIgnoreCase("Ingrese la longitud del itinerario") || texto.equalsIgnoreCase("Ingrese el número máximo de visitantes")) {
            return true;
        }
        if (texto.trim().isEmpty()) { //Misma función que el isBlank
            return true;
        }
        return false;
    }

    /**
     * Método que valida que el nombre contenga de 3 a 40 caracteres, siendo
     * estos: letras, espacios y guiones.
     *
     * @param s Cadena de texto.
     * @return coincidencia entre los validadores y la cadena de texto.
     */
    public boolean esNombre(String s) {
        String patron = "(([a-z]|[A-Z])|([ '-]([a-z]|[A-Z]))){3,40}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Método que valida que el teléfono contenga de 1 a 10 caracteres, siendo
     * estos números.
     *
     * @param s Cadena de texto.
     * @return coincidencia entre los validadores y la cadena de texto.
     */
    public boolean esTelefono(String s) {
        String patron = "([0-9]){1,10}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     *
     * Método que comprueba si una cadena de texto representa un número entero.
     *
     * @param texto La cadena de texto a verificar.
     * @return true si la cadena de texto representa un número entero válido,
     * false en caso contrario.
     */
    public static boolean esEntero(String texto) {
        try {
            if (!esTextoVacio(texto)) {
                Integer.parseInt(texto);
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     *
     * Método que comprueba si una cadena de texto representa un número decimal.
     *
     * @param texto La cadena de texto a verificar.
     * @return true si la cadena de texto representa un número decimal válido,
     * false en caso contrario.
     */
    public static boolean esDecimal(String texto) {
        try {
            if (!esTextoVacio(texto)) {
                Float.parseFloat(texto);
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     *
     * Método que comprueba si el número de visitantes excede el límite
     * permitido.
     *
     * @param texto El número de visitantes como cadena de texto.
     * @return true si el número de visitantes excede el límite, false en caso
     * contrario.
     */
    public static boolean excedeNoVisitantes(String texto) {
        try {
            if (!esTextoVacio(texto)) {
                int numero = Integer.parseInt(texto);
                if (numero > 0 && numero <= 30) {
                    return false; // Cambiado a false para indicar que no excede el límite
                } else {
                    return true; // Cambiado a true para indicar que excede el límite
                }
            } else {
                return false; // Agregado un return false para manejar el caso de texto vacío
            }
        } catch (NumberFormatException e) {
            return false; // Si el texto no puede ser convertido a número, retorna falso
        }
    }

    /**
     *
     * Método que comprueba si una tabla está vacía.
     *
     * @param table La tabla a verificar.
     * @return true si la tabla está vacía, false en caso contrario.
     */
    public static boolean esTablaVacia(JTable table) {
        if (table == null || table.getRowCount() == 0) {
            return true;
        }
        return false;
    }

}
