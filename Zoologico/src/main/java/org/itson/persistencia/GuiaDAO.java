/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.itson.dominio.DireccionGuia;
import org.itson.dominio.Guia;
import org.itson.dominio.TelefonoGuia;
import org.itson.interfaces.IGuiaDAO;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class GuiaDAO implements IGuiaDAO {

    private final ConexionMongoDB CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final String NOMBRE_COLECCION = "guias";

    public GuiaDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.BASE_DATOS = conexion.getBaseDatos();
    }

    /**
     * Inserta un objeto Guia en la base de datos. El teléfono y la dirección se
     * insertan como anidaciones dentro del documento de Guia. La contraseña se
     * encripta antes de ser almacenada.
     */
    @Override
    public void insertarGuia() {
        MongoCollection<Guia> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Guia.class);

        Guia guia = new Guia();
        guia.setNombre("Misael Marchena Tilin");
        guia.setContrasenia(encriptarContrasenia("qwerty123"));
        Date fechaInicio = new Date(1969 - 1900, 3, 4); // El mes se resta en 1 porque en Java los meses van de 0 a 11
        guia.setFechaInicio(fechaInicio);

        // Crear anidaciones para teléfono y dirección
        ArrayList<TelefonoGuia> telefonos = new ArrayList<>();
        TelefonoGuia telefono = new TelefonoGuia();
        TelefonoGuia telefono2 = new TelefonoGuia();
        telefono.setTelefono("6444206901");
        telefono2.setTelefono("6442341234");
        telefonos.add(telefono);
        telefonos.add(telefono2);
        guia.setTelefono(telefonos);

        ArrayList<DireccionGuia> direcciones = new ArrayList<>();
        DireccionGuia direccion = new DireccionGuia();
        direccion.setCalle("De los tilines");
        direccion.setColonia("Altamar");
        direccion.setNumero("420");
        direcciones.add(direccion);
        guia.setDireccion(direcciones);

        coleccion.insertOne(guia);
    }

    /**
     * Encripta una contraseña utilizando el algoritmo de hash SHA-256.
     *
     * @param contrasenia La contraseña a encriptar.
     * @return La contraseña encriptada.
     */
    private String encriptarContrasenia(String contrasenia) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(contrasenia.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }

        return null;
    }
}
