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
    private Integer duracion;
    private Float longitud;
    private Integer noVisitantes;

    public Itinerario() {
    }

    public Itinerario(String nombre, Integer duracion, Float longitud, Integer noVisitantes) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.longitud = longitud;
        this.noVisitantes = noVisitantes;
    }

    public Itinerario(ObjectId id, String nombre, Integer duracion, Float longitud, Integer noVisitantes) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.longitud = longitud;
        this.noVisitantes = noVisitantes;
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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Integer getNoVisitantes() {
        return noVisitantes;
    }

    public void setNoVisitantes(Integer noVisitantes) {
        this.noVisitantes = noVisitantes;
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
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", longitud=" + longitud + ", noVisitantes=" + noVisitantes + '}';
    }

}
