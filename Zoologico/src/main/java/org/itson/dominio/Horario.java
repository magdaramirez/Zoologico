/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa un horario.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Horario {

    private ObjectId id;
    private String dia;
    private Date horaInicio;
    private Date horaFin;

    /**
     * Método constructor por defecto.
     */
    public Horario() {
    }

    /**
     * Crea una instancia de Horario con el día, hora de inicio y hora de fin
     * especificados.
     *
     * @param dia El día de la semana.
     * @param horaInicio La hora de inicio.
     * @param horaFin La hora de fin.
     */
    public Horario(String dia, Date horaInicio, Date horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Crea una instancia de Horario con el identificador, día, hora de inicio y
     * hora de fin especificados.
     *
     * @param id El identificador del horario.
     * @param dia El día de la semana.
     * @param horaInicio La hora de inicio.
     * @param horaFin La hora de fin.
     */
    public Horario(ObjectId id, String dia, Date horaInicio, Date horaFin) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el identificador del horario.
     *
     * @return El identificador del horario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del horario.
     *
     * @param id El identificador del horario.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el día de la semana.
     *
     * @return El día de la semana.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de la semana.
     *
     * @param dia El día de la semana.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Obtiene la hora de inicio.
     *
     * @return La hora de inicio.
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio.
     *
     * @param horaInicio La hora de inicio.
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin.
     *
     * @return La hora de fin.
     */
    public Date getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin.
     *
     * @param horaFin La hora de fin.
     */
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Calcula el hash code del horario.
     *
     * @return El hash code del horario.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara si este horario es igual a otro objeto.
     *
     * @param obj El objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horario other = (Horario) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena del horario.
     *
     * @return Una cadena que representa el horario.
     */
    @Override
    public String toString() {
        return dia;
    }

}
