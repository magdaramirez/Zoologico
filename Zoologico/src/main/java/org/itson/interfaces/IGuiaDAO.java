/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Guia;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface IGuiaDAO {

    /**
     * Método que inserta un guía.
     */
    void insertarGuia();

    /**
     * Método que obtiene un guía.
     *
     * @return Guía.
     */
    Guia obtenerGuia();
}
