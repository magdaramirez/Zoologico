/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.itson.dominio.Habitat;
import org.itson.dominio.Zona;
import org.itson.interfaces.IZonasDAO;

/**
 * Clase que implementa la interfaz IZonasDAO y proporciona métodos para
 * insertar y obtener zonas en la base de datos.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class ZonasDAO implements IZonasDAO {

    private final ConexionMongoDB CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final String NOMBRE_COLECCION = "zonas";

    /**
     * Método constructor que inicializa la conexión y la base de datos.
     *
     * @param conexion Conexión a la base de datos.
     */
    public ZonasDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.BASE_DATOS = conexion.getBaseDatos();
    }

    /**
     * Método que agrega una zona.
     *
     * @param zona Zona a agregar.
     * @return Zona agregada.
     */
    @Override
    public Zona agregar(Zona zona) {
        //OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Zona> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Zona.class);

        //INSERCIÓN DE DOCUMENTOS
        coleccion.insertOne(zona);

        return zona;
    }

    /**
     * Método que actualiza una zona ingresada.
     *
     * @param zona Zona a actualizar.
     * @return Zona actualizada.
     */
    @Override
    public Zona actualizar(Zona zona) {
        //OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Zona> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Zona.class);

        //CREACIÓN DEL FILTRO PARA IDENTIFICAR EL DOCUMENTO A ACTUALIZAR
        Bson filtro = Filters.eq("_id", zona.getId());

        //CREACIÓN DEL OBJETO DE ACTUALIZACIÓN
        Bson actualizacion = new Document("$set", zona);

        //ACTUALIZACIÓN DEL DOCUMENTO
        UpdateOptions opciones = new UpdateOptions().upsert(true);
        coleccion.updateOne(filtro, actualizacion, opciones);

        return zona;
    }

    /**
     * Método que obtiene una lista de las zonas registradas.
     *
     * @return Lista de todas las zonas registradas.
     */
    @Override
    public List<Zona> consultarTodos() {
        //OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Zona> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Zona.class);
        List<Zona> zonas = new LinkedList<>();
        FindIterable resultadosConsultar = coleccion.find();
        resultadosConsultar.into(zonas);

        return zonas;
    }

    /**
     * Método que consulta las zonas con ciertos habitats.
     *
     * @param habitats Habitats de las zonas que se quieren consultar.
     * @return Lista de zonas con los habitats ingresados.
     */
    @Override
    public List<Zona> consultarZonasConHabitats(List<Habitat> habitats) {
        // Obtención de acceso a la colección de zonas
        MongoCollection<Zona> coleccionZonas = BASE_DATOS.getCollection(NOMBRE_COLECCION, Zona.class);

        // Crear una lista para almacenar las zonas con hábitats
        List<Zona> zonasConHabitats = new ArrayList<>();

        // Crear el filtro para buscar las zonas que contengan al menos uno de los hábitats de la lista
        Bson filtro = Filters.in("habitats._id", obtenerIdsHabitats(habitats));

        // Realizar la consulta y obtener los resultados
        FindIterable<Zona> resultados = coleccionZonas.find(filtro);
        MongoCursor<Zona> cursor = resultados.iterator();
        while (cursor.hasNext()) {
            Zona zona = cursor.next();
            if (zona.getHabitat() != null && !zona.getHabitat().isEmpty()) {
                zonasConHabitats.add(zona);
            }
        }

        return zonasConHabitats;
    }

    /**
     * Método que otiene los ObjectId de los habitats en una lista ingresada.
     *
     * @param habitats Lista de habitats de los que se desea obtener los
     * ObjectId
     * @return Lista de ObjectId de los habitats ingresados.
     */
    @Override
    public List<ObjectId> obtenerIdsHabitats(List<Habitat> habitats) {
        List<ObjectId> idsHabitats = new ArrayList<>();
        for (Habitat habitat : habitats) {
            idsHabitats.add(habitat.getId());
        }
        return idsHabitats;
    }

}
