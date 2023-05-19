/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 * Clase que representa el teléfono de un guía.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class TelefonoGuia {

    private String telefono;

    /**
     * Constructor por defecto.
     */
    public TelefonoGuia() {
    }

    /**
     * Crea una instancia de la clase TelefonoGuia con el número de teléfono
     * especificado.
     *
     * @param telefono El número de teléfono del guía.
     */
    public TelefonoGuia(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el número de teléfono del guía.
     *
     * @return El número de teléfono del guía.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del guía.
     *
     * @param telefono El número de teléfono del guía a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación en forma de cadena del número de teléfono del
     * guía.
     *
     * @return La representación en forma de cadena del número de teléfono del
     * guía.
     */
    @Override
    public String toString() {
        return "TelefonoGuia{" + "telefono=" + telefono + '}';
    }

}
