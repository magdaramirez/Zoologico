/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author magda
 */
public class Horario {

    private ObjectId id;
    private String dia;
    private Date horaInicio;
    private Date horaFin;

    public Horario() {
    }

    public Horario(String dia, Date horaInicio, Date horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Horario(ObjectId id, String dia, Date horaInicio, Date horaFin) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }

}
