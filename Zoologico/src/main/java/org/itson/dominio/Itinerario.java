/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa un itinerario.
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

    /**
     * Método constructor por defecto.
     */
    public Itinerario() {
    }

    /**
     * Crea una instancia de Itinerario con el nombre, número de visitantes,
     * longitud, duración, lista de horarios, lista de zonas y lista de hábitats
     * especificados.
     *
     * @param nombre El nombre del itinerario.
     * @param noVisitantes El número de visitantes.
     * @param longitud La longitud.
     * @param duracion La duración.
     * @param listaHorarios La lista de horarios.
     * @param listaZonas La lista de zonas.
     * @param listaHabitats La lista de hábitats.
     */
    public Itinerario(String nombre, Integer noVisitantes, Float longitud, Integer duracion, List<Horario> listaHorarios, List<Zona> listaZonas, List<Habitat> listaHabitats) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.longitud = longitud;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
        this.listaZonas = listaZonas;
        this.listaHabitats = listaHabitats;
    }

    /**
     * Crea una instancia de Itinerario con el identificador, nombre, número de
     * visitantes, longitud, duración, lista de horarios, lista de zonas y lista
     * de hábitats especificados.
     *
     * @param id El identificador del itinerario.
     * @param nombre El nombre del itinerario.
     * @param noVisitantes El número de visitantes.
     * @param longitud La longitud.
     * @param duracion La duración.
     * @param listaHorarios La lista de horarios.
     * @param listaZonas La lista de zonas.
     * @param listaHabitats La lista de hábitats.
     */
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

    /**
     * Crea una instancia de Itinerario con el nombre, número de visitantes,
     * longitud, duración y lista de horarios especificados.
     *
     * @param nombre El nombre del itinerario.
     * @param noVisitantes El número de visitantes.
     * @param longitud La longitud.
     * @param duracion La duración.
     * @param listaHorarios La lista de horarios.
     */
    public Itinerario(String nombre, Integer noVisitantes, Float longitud, Integer duracion, List<Horario> listaHorarios) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.longitud = longitud;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
    }

    /**
     * Crea una instancia de Itinerario con el nombre, número de visitantes,
     * duración y lista de horarios especificados.
     *
     * @param nombre El nombre del itinerario.
     * @param noVisitantes El número de visitantes.
     * @param duracion La duración.
     * @param listaHorarios La lista de horarios.
     */
    public Itinerario(String nombre, Integer noVisitantes, Integer duracion, List<Horario> listaHorarios) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.duracion = duracion;
        this.listaHorarios = listaHorarios;
    }

    /**
     * Crea una instancia de Itinerario con el nombre, número de visitantes,
     * lista de horarios y lista de hábitats especificados.
     *
     * @param nombre El nombre del itinerario.
     * @param noVisitantes El número de visitantes.
     * @param listaHorarios La lista de horarios.
     * @param listaHabitats La lista de hábitats.
     */
    public Itinerario(String nombre, Integer noVisitantes, List<Horario> listaHorarios, List<Habitat> listaHabitats) {
        this.nombre = nombre;
        this.noVisitantes = noVisitantes;
        this.listaHorarios = listaHorarios;
        this.listaHabitats = listaHabitats;
    }

    /**
     * Devuelve el identificador del itinerario.
     *
     * @return El identificador del itinerario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del itinerario.
     *
     * @param id El identificador del itinerario a establecer.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del itinerario.
     *
     * @return El nombre del itinerario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del itinerario.
     *
     * @param nombre El nombre del itinerario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el número de visitantes del itinerario.
     *
     * @return El número de visitantes del itinerario.
     */
    public Integer getNoVisitantes() {
        return noVisitantes;
    }

    /**
     * Establece el número de visitantes del itinerario.
     *
     * @param noVisitantes El número de visitantes del itinerario a establecer.
     */
    public void setNoVisitantes(Integer noVisitantes) {
        this.noVisitantes = noVisitantes;
    }

    /**
     * Devuelve la longitud del itinerario.
     *
     * @return La longitud del itinerario.
     */
    public Float getLongitud() {
        return longitud;
    }

    /**
     * Establece la longitud del itinerario.
     *
     * @param longitud La longitud del itinerario a establecer.
     */
    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve la duración del itinerario.
     *
     * @return La duración del itinerario.
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del itinerario.
     *
     * @param duracion La duración del itinerario a establecer.
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    /**
     * Devuelve la lista de horarios del itinerario.
     *
     * @return La lista de horarios del itinerario.
     */
    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    /**
     * Establece la lista de horarios del itinerario.
     *
     * @param listaHorarios La lista de horarios del itinerario a establecer.
     */
    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    /**
     * Devuelve la lista de zonas del itinerario.
     *
     * @return La lista de zonas del itinerario.
     */
    public List<Zona> getListaZonas() {
        return listaZonas;
    }

    /**
     * Establece la lista de zonas del itinerario.
     *
     * @param listaZonas La lista de zonas del itinerario a establecer.
     */
    public void setListaZonas(List<Zona> listaZonas) {
        this.listaZonas = listaZonas;
    }

    /**
     * Devuelve la lista de hábitats del itinerario.
     *
     * @return La lista de hábitats del itinerario.
     */
    public List<Habitat> getListaHabitats() {
        return listaHabitats;
    }

    /**
     * Establece la lista de hábitats del itinerario.
     *
     * @param listaHabitats La lista de hábitats del itinerario a establecer.
     */
    public void setListaHabitats(List<Habitat> listaHabitats) {
        this.listaHabitats = listaHabitats;
    }

    /**
     * Calcula el código hash del itinerario.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara si el itinerario actual es igual a otro objeto dado.
     *
     * @param obj El objeto a comparar.
     * @return true si el itinerario es igual al objeto dado, false de lo
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
        final Itinerario other = (Itinerario) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena del itinerario.
     *
     * @return La representación en forma de cadena del itinerario.
     */
    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", noVisitantes=" + noVisitantes + ", longitud=" + longitud + ", duracion=" + duracion + ", listaHorarios=" + listaHorarios + ", listaZonas=" + listaZonas + ", listaHabitats=" + listaHabitats + '}';
    }

}
