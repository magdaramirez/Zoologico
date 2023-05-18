/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.conversions.Bson;
import org.itson.dominio.Habitat;
import org.itson.interfaces.IHabitatsDAO;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class HabitatsDAO implements IHabitatsDAO {

    private final ConexionMongoDB CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final String NOMBRE_COLECCION = "habitats";

    public HabitatsDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.BASE_DATOS = conexion.getBaseDatos();
    }

    @Override
    public Habitat agregar(Habitat habitat) {
        //OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Habitat.class);

        //INSERCIÓN DE DOCUMENTOS
        coleccion.insertOne(habitat);

        return habitat;
    }

    @Override
    public List<Habitat> consultarTodos() {
        // OBTENCIÓN DE ACCESO A LA COLECCIÓN
        MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Habitat.class);
        List<Habitat> habitats = new ArrayList<>();  // Usar ArrayList en lugar de LinkedList

        // Consultar y almacenar los resultados en la lista de hábitats
        FindIterable<Habitat> resultadosConsultar = coleccion.find();
        MongoCursor<Habitat> cursor = resultadosConsultar.iterator();
        while (cursor.hasNext()) {
            Habitat habitat = cursor.next();
            habitats.add(habitat);
        }

        return habitats;
    }

    @Override
    public Habitat obtenerHabitat(String nombre) {
        // Obtención de acceso a la colección
        MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Habitat.class);

        // Crear el filtro de búsqueda por nombre
        Bson filtro = Filters.eq("nombre", nombre);

        // Realizar la consulta y obtener el primer documento que cumpla con el filtro
        Habitat habitat = coleccion.find(filtro).first();

        return habitat;
    }

}
