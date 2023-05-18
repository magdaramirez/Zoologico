/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.fachadaAdministrarItinerario;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Zona;
import org.itson.interfaces.IZonasDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.persistencia.ZonasDAO;
import org.itson.utils.Validadores;

/**
 *
 * @author march
 */
public class FachadaAdministrarItinerario implements IAdministrarItinerario {

    @Override
    public boolean registrarItinerario(Itinerario itinerario, ConexionMongoDB conexion) {
        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        this.generarRecorrido(itinerario);
        String validacion = "nombre";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Nombre repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        validacion = "visitantes";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Visitantes", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        validacion = "horarios";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Hora inicio de horario repetido en el mismo día", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            itinerariosDAO.agregar(itinerario);
            JOptionPane.showMessageDialog(null, "Se ha guardado el itinerario " + itinerario.getNombre(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
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
    public void generarRecorrido(Itinerario itinerario) {
        ConexionMongoDB conexion = new ConexionMongoDB();
        IZonasDAO persistenciaZona = new ZonasDAO(conexion);
        List<Zona> zonasConHabitats = persistenciaZona.consultarZonasConHabitats(itinerario.getListaHabitats());
        itinerario.setListaZonas(zonasConHabitats);
    }
}
