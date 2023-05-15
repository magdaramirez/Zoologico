/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author magda
 */
public class Itinerario {

    private ObjectId id;
    private String nombre;
    private Integer noVisitantes;
    private List<Horario> listaHorarios;
    private List<Zona> listaZonas;

    public Itinerario() {
    }

    public Itinerario(String nombre, Integer noVisitantes, List<Horario> listaHorarios, List<Zona> listaZonas) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.listaHorarios = listaHorarios;
        this.listaZonas = listaZonas;
    }

    public Itinerario(ObjectId id, String nombre, Integer noVisitantes, List<Horario> listaHorarios, List<Zona> listaZonas) {
        this.id = id;
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.listaHorarios = listaHorarios;
        this.listaZonas = listaZonas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNoVisitantes() {
        return noVisitantes;
    }

    public void setNoVisitantes(Integer noVisitantes) {
        this.noVisitantes = noVisitantes;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    public List<Zona> getListaZonas() {
        return listaZonas;
    }

    public void setListaZonas(List<Zona> listaZonas) {
        this.listaZonas = listaZonas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Itinerario other = (Itinerario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", noVisitantes=" + noVisitantes + ", listaHorarios=" + listaHorarios + ", listaZonas=" + listaZonas + '}';
    }

}
