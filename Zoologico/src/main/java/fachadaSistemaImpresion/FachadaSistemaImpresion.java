/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadaSistemaImpresion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import org.itson.GUI.PnlBotones;
import org.itson.dominio.Itinerario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.utils.JasperByCollectionBeanData;

/**
 *
 * @author march
 */
public class FachadaSistemaImpresion implements ISistemaImpresion {
    /**
     * Método para mostrar la pantalla de impresión del itinerario seleccionado.
     * @param itinerarioObtenido Itinerario que se mostrará.
     */
    @Override
    public void imprimir(Itinerario itinerarioObtenido) {
        List<Itinerario> listaItinerarios = new ArrayList<>();
        listaItinerarios.add(itinerarioObtenido);

        ConexionMongoDB conexion = new ConexionMongoDB();
        ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        try {
            JasperByCollectionBeanData.crearPDF(listaItinerarios);
        } catch (JRException ex) {
            Logger.getLogger(PnlBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
