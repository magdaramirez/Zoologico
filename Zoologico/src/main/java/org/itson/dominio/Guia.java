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
 * Clase que representa un guía.
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

    /**
     * Constructor por defecto de la clase guía.
     */
    public Guia() {
    }

    /**
     * Constructor de la clase Guia que recibe los valores de la contraseña, el
     * nombre, la fecha de inicio, los números de teléfono y las direcciones.
     *
     * @param contrasenia La contraseña del guía.
     * @param nombre El nombre del guía.
     * @param fechaInicio La fecha de inicio del guía.
     * @param telefono Los números de teléfono del guía.
     * @param direccion Las direcciones del guía.
     */
    public Guia(String contrasenia, String nombre, Date fechaInicio, ArrayList telefono, ArrayList direccion) {
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /**
     * Obtiene el ID del guía.
     *
     * @return El ID del guía.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del guía.
     *
     * @param id El ID del guía.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la contraseña del guía.
     *
     * @return La contraseña del guía.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del guía.
     *
     * @param contrasenia La contraseña del guía.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el nombre del guía.
     *
     * @return El nombre del guía.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del guía.
     *
     * @param nombre El nombre del guía.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de inicio del guía.
     *
     * @return La fecha de inicio del guía.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del guía.
     *
     * @param fechaInicio La fecha de inicio del guía.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene los números de teléfono del guía.
     *
     * @return Los números de teléfono del guía.
     */
    public ArrayList getTelefono() {
        return telefono;
    }

    /**
     * Establece los números de teléfono del guía.
     *
     * @param telefono Los números de teléfono del guía.
     */
    public void setTelefono(ArrayList telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene las direcciones del guía.
     *
     * @return Las direcciones del guía.
     */
    public ArrayList getDireccion() {
        return direccion;
    }

    /**
     * Establece las direcciones del guía.
     *
     * @param direccion Las direcciones del guía.
     */
    public void setDireccion(ArrayList direccion) {
        this.direccion = direccion;
    }

    /**
     * Calcula el código hash del objeto guía.
     *
     * @return El código hash del objeto guía.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara si el objeto guía es igual a otro objeto.
     *
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false de lo contrario.
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
        final Guia other = (Guia) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena del objeto guía.
     *
     * @return La representación en forma de cadena del objeto guía.
     */
    @Override
    public String toString() {
        return "Guia{" + "id=" + id + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
