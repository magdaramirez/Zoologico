/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author magda
 */
public class Zona {

    private ObjectId id;
    private String nombre;
    private Integer duracion;
    private Zona[] direcciones;

    public Zona() {
    }

    public Zona(String nombre, Integer duracion, Zona[] direcciones) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.direcciones = direcciones;
    }

    public Zona(ObjectId id, String nombre, Integer duracion, Zona[] direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.direcciones = direcciones;
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

    public Zona[] getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Zona[] direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Zona other = (Zona) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Zona{" + "id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", direcciones=" + direcciones + '}';
    }

}
