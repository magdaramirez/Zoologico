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
public class TelefonoGuia {

    private ObjectId id;
    private String numero;

    public TelefonoGuia() {
    }

    public TelefonoGuia(String numero) {
        this.numero = numero;
    }

    public TelefonoGuia(ObjectId id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final TelefonoGuia other = (TelefonoGuia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "TelefonoGuia{" + "id=" + id + ", numero=" + numero + '}';
    }

}
