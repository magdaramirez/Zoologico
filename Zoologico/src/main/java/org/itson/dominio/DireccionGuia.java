/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 * Clase que representa una dirección de un guía.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class DireccionGuia {

    private String calle;
    private String numero;
    private String colonia;

    /**
     * Constructor por defecto de la clase DireccionGuia.
     */
    public DireccionGuia() {
    }

    /**
     * Constructor de la clase DireccionGuia que recibe los valores de la calle,
     * el número y la colonia.
     *
     * @param calle La calle de la dirección.
     * @param numero El número de la dirección.
     * @param colonia La colonia de la dirección.
     */
    public DireccionGuia(String calle, String numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    /**
     * Obtiene la calle de la dirección.
     *
     * @return La calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param calle La calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la dirección.
     *
     * @return El número de la dirección.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección.
     *
     * @param numero El número de la dirección.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la colonia de la dirección.
     *
     * @return La colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección.
     *
     * @param colonia La colonia de la dirección.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Devuelve una representación en forma de cadena de la dirección.
     *
     * @return La representación en forma de cadena de la dirección.
     */
    @Override
    public String toString() {
        return "direccionGuia{" + "calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + '}';
    }

}
