/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Calendar;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author magda
 */
public class Guia {

    private ObjectId id;
    private String contrasenia;
    private String nombre;
    private ObjectId idDireccion;
    private ObjectId idTelefono;
    private Calendar fechaInicio;

    public Guia() {
    }

    public Guia(String contrasenia, String nombre, ObjectId idDireccion, ObjectId idTelefono, Calendar fechaInicio) {
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.idDireccion = idDireccion;
        this.idTelefono = idTelefono;
        this.fechaInicio = fechaInicio;
    }

    public Guia(ObjectId id, String contrasenia, String nombre, ObjectId idDireccion, ObjectId idTelefono, Calendar fechaInicio) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.idDireccion = idDireccion;
        this.idTelefono = idTelefono;
        this.fechaInicio = fechaInicio;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObjectId getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(ObjectId idDireccion) {
        this.idDireccion = idDireccion;
    }

    public ObjectId getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(ObjectId idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Guia other = (Guia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Guia{" + "id=" + id + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", idDireccion=" + idDireccion + ", idTelefono=" + idTelefono + ", fechaInicio=" + fechaInicio + '}';
    }

}
