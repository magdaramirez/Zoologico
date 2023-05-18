/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.fachadaAdministrarItinerario;

import org.itson.dominio.Itinerario;
import org.itson.persistencia.ConexionMongoDB;

/**
 *
 * @author march
 */
public interface IAdministrarItinerario {

    public boolean registrarItinerario(Itinerario itinerario, ConexionMongoDB conexion);
    public boolean validacion(Itinerario itinerario, String campo, ConexionMongoDB conexion);
    public void generarRecorrido(Itinerario itinerario);
}
