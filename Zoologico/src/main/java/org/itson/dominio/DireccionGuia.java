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
public class DireccionGuia {

    private ObjectId id;
    private String calle;
    private String numero;
    private String colonia;

    public DireccionGuia() {
    }

    public DireccionGuia(String calle, String numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    public DireccionGuia(ObjectId id, String calle, String numero, String colonia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final DireccionGuia other = (DireccionGuia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "DireccionGuia{" + "idDireccion=" + id + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + '}';
    }

}
