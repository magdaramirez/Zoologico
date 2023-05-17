/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Zona {

    private ObjectId id;
    private String nombre;
    private Integer duracion = 10;
    private List<ObjectId> direcciones;
    private ArrayList habitat;

    public Zona() {
    }

    public Zona(ObjectId id, String nombre, List<ObjectId> direcciones, ArrayList habitat) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
        this.habitat = habitat;
    }

    public Zona(String nombre, List<ObjectId> direcciones, ArrayList habitat) {
        this.nombre = nombre;
        this.direcciones = direcciones;
        this.habitat = habitat;
    }
    
    public Zona(ObjectId id, String nombre, ArrayList habitat) {
        this.id = id;
        this.nombre = nombre;
        this.habitat = habitat;
    }

    public Zona(String nombre, ArrayList habitat) {
        this.nombre = nombre;
        this.habitat = habitat;
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

    public List<ObjectId> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<ObjectId> direcciones) {
        this.direcciones = direcciones;
    }

    public ArrayList getHabitat() {
        return habitat;
    }

    public void setHabitat(ArrayList habitat) {
        this.habitat = habitat;
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
        return "Zona{" + "id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", direcciones=" + direcciones + ", habitat=" + habitat + '}';
    }

}
