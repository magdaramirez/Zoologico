/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Habitat;
import org.itson.dominio.Zona;

/**
 * Clase interfaz que define las operaciones para acceder y manipular los datos
 * de una zona.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface IZonasDAO {

    /**
     * Método que agrega una zona.
     *
     * @param zona Zona a agregar.
     * @return Zona agregada.
     */
    Zona agregar(Zona zona);

    /**
     * Método que actualiza una zona ingresada.
     *
     * @param zona Zona a actualizar.
     * @return Zona actualizada.
     */
    Zona actualizar(Zona zona);

    /**
     * Método que obtiene una lista de las zonas registradas.
     *
     * @return Lista de todas las zonas registradas.
     */
    List<Zona> consultarTodos();

    /**
     * Método que consulta las zonas con ciertos habitats.
     *
     * @param habitats Habitats de las zonas que se quieren consultar.
     * @return Lista de zonas con los habitats ingresados.
     */
    List<Zona> consultarZonasConHabitats(List<Habitat> habitats);

    /**
     * Método que otiene los ObjectId de los habitats en una lista ingresada.
     *
     * @param habitats Lista de habitats de los que se desea obtener los
     * ObjectId
     * @return Lista de ObjectId de los habitats ingresados.
     */
    List<ObjectId> obtenerIdsHabitats(List<Habitat> habitats);
}
