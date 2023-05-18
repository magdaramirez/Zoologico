/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadaSistemaImpresion;

import org.itson.dominio.Itinerario;

/**
 *
 * @author march
 */
public interface ISistemaImpresion {
    /**
     * Método para mostrar la pantalla de impresión del itinerario seleccionado.
     * @param itinerarioObtenido Itinerario que se mostrará.
     */
    public void imprimir(Itinerario itinerarioObtenido);
}
