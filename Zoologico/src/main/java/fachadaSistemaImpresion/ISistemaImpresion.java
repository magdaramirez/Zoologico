/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadaSistemaImpresion;

import org.itson.dominio.Itinerario;

/**
 * Clase interfaz que define el método para mostrar la pantalla de impresión del
 * itinerario seleccionado.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface ISistemaImpresion {

    /**
     * Método para mostrar la pantalla de impresión del itinerario seleccionado.
     *
     * @param itinerarioObtenido Itinerario que se mostrará.
     */
    public void imprimir(Itinerario itinerarioObtenido);
}
