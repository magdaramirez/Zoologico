/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.fachadaAdministrarItinerario;

import java.util.Date;
import java.util.List;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.utils.Validadores;

/**
 *
 * @author march
 */
public class FachadaAdministrarItinerario implements IAdministrarItinerario {

    @Override
    public boolean registrarItinerario(Itinerario itinerario, ConexionMongoDB conexion) {
        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        this.generarRecorrido();
        Itinerario itinerarioRegistrado = itinerariosDAO.agregar(itinerario);
        return itinerarioRegistrado != null;
    }

    @Override
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
                for (Horario horario : listaHorarios) {
                    String dia = horario.getDia();
                    Date horaInicio = horario.getHoraInicio();

                    // Verificar si existe otro itinerario con la misma hora de inicio para el mismo día
                    List<Itinerario> itinerariosMismoHorario = itinerariosDAO.consultarPorHoraInicio(dia, horaInicio);
                    if (itinerariosMismoHorario.size() >= 1) {
                        return false;
                    }
                }
                return true;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void generarRecorrido() {

    }
}
