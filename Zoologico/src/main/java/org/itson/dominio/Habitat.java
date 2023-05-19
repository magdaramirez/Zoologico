/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa un hábitat.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Habitat {

    private ObjectId id;
    private String nombre;
    private String clima;
    private String vegetacion;
    private Continente continente;

    /**
     * Constructor por defecto de la clase.
     */
    public Habitat() {
    }

    /**
     * Constructor de la clase Habitat con el nombre especificado.
     *
     * @param nombre el nombre del hábitat.
     */
    public Habitat(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor de la clase Habitat con los atributos especificados.
     *
     * @param nombre el nombre del hábitat.
     * @param clima el clima del hábitat.
     * @param vegetacion la vegetación del hábitat.
     * @param continente el continente al que pertenece el hábitat.
     */
    public Habitat(String nombre, String clima, String vegetacion, Continente continente) {
        this.nombre = nombre;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continente = continente;
    }

    /**
     * Constructor de la clase Habitat con el identificador, nombre, clima,
     * vegetación y continente especificados.
     *
     * @param id el identificador del hábitat.
     * @param nombre el nombre del hábitat.
     * @param clima el clima del hábitat.
     * @param vegetacion la vegetación del hábitat.
     * @param continente el continente al que pertenece el hábitat.
     */
    public Habitat(ObjectId id, String nombre, String clima, String vegetacion, Continente continente) {
        this.id = id;
        this.nombre = nombre;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continente = continente;
    }

    /**
     * Obtiene el identificador del hábitat.
     *
     * @return el identificador del hábitat.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del hábitat.
     *
     * @param id el identificador del hábitat.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del hábitat.
     *
     * @return el nombre del hábitat.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del hábitat.
     *
     * @param nombre el nombre del hábitat.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el clima del hábitat.
     *
     * @return el clima del hábitat.
     */
    public String getClima() {
        return clima;
    }

    /**
     * Establece el clima del hábitat.
     *
     * @param clima el clima del hábitat.
     */
    public void setClima(String clima) {
        this.clima = clima;
    }

    /**
     * Obtiene la vegetación del hábitat.
     *
     * @return la vegetación del hábitat.
     */
    public String getVegetacion() {
        return vegetacion;
    }

    /**
     * Establece la vegetación del hábitat.
     *
     * @param vegetacion la vegetación del hábitat.
     */
    public void setVegetacion(String vegetacion) {
        this.vegetacion = vegetacion;
    }

    /**
     * Obtiene el continente al que pertenece el hábitat.
     *
     * @return el continente al que pertenece el hábitat.
     */
    public Continente getContinente() {
        return continente;
    }

    /**
     * Establece el continente al que pertenece el hábitat.
     *
     * @param continente el continente al que pertenece el hábitat.
     */
    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    /**
     * Calcula el hash code del hábitat.
     *
     * @return el hash code del hábitat.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el hábitat con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto a comparar.
     * @return true si el hábitat es igual al objeto dado, false en caso
     * contrario.
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
        final Habitat other = (Habitat) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena del hábitat.
     *
     * @return una representación en forma de cadena del hábitat.
     */
    @Override
    public String toString() {
        return nombre;
    }

}
