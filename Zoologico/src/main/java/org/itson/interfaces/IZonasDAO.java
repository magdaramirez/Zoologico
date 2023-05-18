/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Habitat;
import org.itson.dominio.Zona;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public interface IZonasDAO {

    Zona agregar(Zona zona);

    Zona actualizar(Zona zona);

    List<Zona> consultarTodos();

    List<Zona> consultarZonasConHabitats(List<Habitat> habitats);
}
