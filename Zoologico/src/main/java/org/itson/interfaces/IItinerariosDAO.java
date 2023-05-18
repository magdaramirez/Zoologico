/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.Date;
import java.util.List;
import org.itson.dominio.Itinerario;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface IItinerariosDAO {

    Itinerario agregar(Itinerario itinerario);

    List<Itinerario> consultarTodos();
    
    Itinerario obtener(String nombre);
    
    boolean obtenerItinerarios();
    
    List<Itinerario> consultarPorHoraInicio(String dia, Date horaInicio);
}
