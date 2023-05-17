/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Guia {

    private ObjectId id;
    private String contrasenia;
    private String nombre;
    private Date fechaInicio;
    private ArrayList telefono;
    private ArrayList direccion;

    public Guia() {
    }

    public Guia(String contrasenia, String nombre, Date fechaInicio, ArrayList telefono, ArrayList direccion) {
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ArrayList getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList telefono) {
        this.telefono = telefono;
    }

    public ArrayList getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        return "Guia{" + "id=" + id + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
