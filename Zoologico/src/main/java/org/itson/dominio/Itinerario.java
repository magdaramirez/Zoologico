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
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Itinerario {

    private ObjectId id;
    private String nombre;
    private Integer noVisitantes;
    private Float longitud;
    private Integer duracion;
    private List<Horario> listaHorarios;
    private List<Zona> listaZonas;
    private List<Habitat> listaHabitats;

    public Itinerario() {
    }

    public Itinerario(String nombre, Integer noVisitantes, Float longitud, Integer duracion, List<Horario> listaHorarios, List<Zona> listaZonas, List<Habitat> listaHabitats) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.longitud = longitud;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
        this.listaZonas = listaZonas;
        this.listaHabitats = listaHabitats;
    }

    public Itinerario(ObjectId id, String nombre, Integer noVisitantes, Float longitud, Integer duracion, List<Horario> listaHorarios, List<Zona> listaZonas, List<Habitat> listaHabitats) {
        this.id = id;
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.longitud = longitud;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
        this.listaZonas = listaZonas;
        this.listaHabitats = listaHabitats;
    }

    public Itinerario(String nombre, Integer noVisitantes, Float longitud, Integer duracion, List<Horario> listaHorarios) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.longitud = longitud;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
    }

    public Itinerario(String nombre, Integer noVisitantes, Integer duracion, List<Horario> listaHorarios) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
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

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
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

    public List<Habitat> getListaHabitats() {
        return listaHabitats;
    }

    public void setListaHabitats(List<Habitat> listaHabitats) {
        this.listaHabitats = listaHabitats;
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
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", noVisitantes=" + noVisitantes + ", longitud=" + longitud + ", duracion=" + duracion + ", listaHorarios=" + listaHorarios + ", listaZonas=" + listaZonas + ", listaHabitats=" + listaHabitats + '}';
    }

}
