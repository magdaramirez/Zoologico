/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IItinerariosDAO;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
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

    @Override
    public boolean obtenerItinerarios() {
        // Obtener acceso a la colección
        MongoCollection<Document> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION);

        // Verificar si la colección existe
        if (coleccion != null) {
            // Verificar si la colección no está vacía
            return coleccion.countDocuments() > 0;
        }

        return false;
    }

}
