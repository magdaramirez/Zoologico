/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Habitat;

/**
 *
 * @author magda
 */
public interface IHabitatsDAO {

    Habitat agregar(Habitat habitat);

    List<Habitat> consultarTodos();
}
