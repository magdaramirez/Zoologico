/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.fachadaAdministrarItinerario;

import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.utils.Validadores;

/**
 *
 * @author march
 */
public class FachadaAdministrarItinerario {

    public boolean registrarItinerario(Itinerario itinerario, ConexionMongoDB conexion) {
        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        this.generarRecorrido();
        Itinerario itinerarioRegistrado = itinerariosDAO.agregar(itinerario);
        return itinerarioRegistrado != null;
    }

    public boolean validacion(Itinerario itinerario, String campo, ConexionMongoDB conexion) {
        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        switch (campo) {
            case "nombre":
                List<Itinerario> listaItinerario = itinerariosDAO.consultarTodos();
                for (Itinerario itinerario1 : listaItinerario) {
                    if (itinerario.getNombre().equalsIgnoreCase(itinerario1.getNombre())) {
                        return false;
                    }
                }
                return true;
            case "visitantes":
                return Validadores.excedeNumVisitantes(itinerario.getNoVisitantes());
            case "horarios":
                List<Horario> listaHorarios = itinerario.getListaHorarios();
                
                break;
            default:
                throw new AssertionError();
        }
    }

    public void generarRecorrido() {

    }
}
