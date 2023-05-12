/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedList;
import java.util.List;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IItinerariosDAO;

/**
 *
 * @author magda
 */
public class ItinerariosDAO implements IItinerariosDAO {

    private final ConexionMongoDB CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final String NOMBRE_COLECCION = "itinerarios";

    public ItinerariosDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.BASE_DATOS = conexion.getBaseDatos();
    }

    @Override
    public Itinerario agregar(Itinerario itinerario) {
        //OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Itinerario> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Itinerario.class);

        //INSERCIÓN DE DOCUMENTOS (RESTAURANTES)
        coleccion.insertOne(itinerario);

        return itinerario;
    }

    @Override
    public List<Itinerario> consultarTodos() {
        //OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Itinerario> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Itinerario.class);

        List<Itinerario> itinerarios = new LinkedList<>();
        coleccion.find().into(itinerarios);

        return itinerarios;
    }

}
