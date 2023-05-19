/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.Date;
import java.util.List;
import org.itson.dominio.Itinerario;

/**
 * Clase interfaz que define las operaciones para acceder y manipular los datos
 * de un itinerario.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface IItinerariosDAO {

    /**
     * Método para agregar un itinerario.
     *
     * @param itinerario Itinerario que se registrará.
     * @return Itinerario registrado.
     */
    Itinerario agregar(Itinerario itinerario);

    /**
     * Método que obtiene una lista de todos los itinerarios registrados.
     *
     * @return Lista de todos los itinerarios registrados.
     */
    List<Itinerario> consultarTodos();

    /**
     * Método que obtiene un itinerario con un nombre en específico.
     *
     * @param nombre Nombre del itinerario que se desea obtener.
     * @return Itinerario con el nombre ingresado.
     */
    Itinerario obtener(String nombre);

    /**
     * Método que valida si hay itinerarios registrados.
     *
     * @return True o false.
     */
    boolean obtenerItinerarios();

    /**
     * Método que actualiza un itinerario.
     *
     * @param itinerario Itinerario a actualizar.
     */
    public void actualizar(Itinerario itinerario);

    /**
     * Método que obtiene los itinerarios por su hora de inicio.
     *
     * @param dia Día del itinerario que se desea obtener.
     * @param horaInicio Hora de inicio del itinerario que se desea obtener.
     * @return Itinerario con el día y hora de inicio ingresadas.
     */
    List<Itinerario> consultarPorHoraInicio(String dia, Date horaInicio);
}
