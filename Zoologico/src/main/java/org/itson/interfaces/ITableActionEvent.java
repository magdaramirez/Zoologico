/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

/**
 * Clase interfaz que define los métodos para manipular los eventos de acción en
 * una tabla.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface ITableActionEvent {

    /**
     * Método que coloca el botón editar.
     *
     * @param row Fila donde se encontrará.
     */
    public void editar(int row);

    /**
     * Método que coloca el botón imprimir.
     *
     * @param row Fila donde se encontrará.
     */
    public void imprimir(int row);

    /**
     * Método que coloca el botón visualizar.
     *
     * @param row Fila donde se encontrará.
     */
    public void visualizar(int row);
}
