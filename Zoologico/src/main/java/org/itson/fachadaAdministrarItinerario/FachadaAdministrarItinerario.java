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
 * Clase que implementa la interfaz IAdministrarItinerario que proporciona
 * métodos para administrar el itinerario.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class FachadaAdministrarItinerario implements IAdministrarItinerario {

    /**
     * Método que registra un itinerario haciendo validaciones simples.
     *
     * @param itinerario Itinerario a registrar.
     * @param conexion Conexion a la base de datos.
     * @return True o false.
     */
    @Override
    public boolean registrarItinerario(Itinerario itinerario, ConexionMongoDB conexion) {
        int rechazado = 0;
        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        this.generarRecorrido(itinerario);
        String validacion = "duracion";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Duración de recorrido excedida", "ERROR", JOptionPane.ERROR_MESSAGE);
            rechazado++;
        }
        validacion = "nombre";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Nombre repetido", "ERROR", JOptionPane.ERROR_MESSAGE);
            rechazado++;
        }
        validacion = "visitantes";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Número máximo de visitantes excedido (30)", "ERROR", JOptionPane.ERROR_MESSAGE);
            rechazado++;
        }
        validacion = "horarios";
        if (!validacion(itinerario, validacion, conexion)) {
            JOptionPane.showMessageDialog(null, "Hora inicio de horario repetido en el mismo día", "ERROR", JOptionPane.ERROR_MESSAGE);
            rechazado++;
        }
        if (rechazado == 0) {
            itinerariosDAO.agregar(itinerario);
            JOptionPane.showMessageDialog(null, "Se ha guardado el itinerario " + itinerario.getNombre(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    /**
     * Método que hace validaciones del itinerario.
     *
     * @param itinerario Itinerario que se validará.
     * @param campo Campo que se desea validar.
     * @param conexion Conexion a la base de datos.
     * @return True o false.
     */
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
            case "duracion":
                return itinerario.getDuracion() <= 90;
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

    /**
     * Método que genera el recorrido del itinerario.
     *
     * @param itinerario Itinerario donde se sacará el recorrido.
     */
    @Override
    public void generarRecorrido(Itinerario itinerario) {
        ConexionMongoDB conexion = new ConexionMongoDB();
        IZonasDAO persistenciaZona = new ZonasDAO(conexion);
        List<Zona> zonasConHabitats = persistenciaZona.consultarZonasConHabitats(itinerario.getListaHabitats());
        itinerario.setListaZonas(zonasConHabitats);
        Zona zonaAux = new Zona();
        itinerario.setDuracion(itinerario.getListaHabitats().size() * zonaAux.getDuracion());
        itinerario.setLongitud(itinerario.getListaHabitats().size() * 100f);
    }
}
