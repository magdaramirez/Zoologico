/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Habitat;

/**
 * Clase interfaz que define las operaciones para acceder y manipular los datos
 * de un hábitat.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface IHabitatsDAO {

    /**
     * Método que agrega un habitat.
     *
     * @param habitat Habitat a agregar.
     * @return El habitat agegado.
     */
    Habitat agregar(Habitat habitat);

    /**
     * Método que consulta todos los habitats registrados.
     *
     * @return Lista de los habitats registrados.
     */
    List<Habitat> consultarTodos();

    /**
     * Método que obtiene un habitat por su nombre.
     *
     * @param nombre Nombre del habitat que se desea obtener.
     * @return Habitat con el nombre ingresado.
     */
    public Habitat obtenerHabitat(String nombre);
}
