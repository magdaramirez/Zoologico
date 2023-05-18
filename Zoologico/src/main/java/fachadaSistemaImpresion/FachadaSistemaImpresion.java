/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadaSistemaImpresion;

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

    @Override
    public void imprimir() {
        ConexionMongoDB conexion = new ConexionMongoDB();
        ItinerariosDAO itinerarios = new ItinerariosDAO(conexion);
        List<Itinerario> listaItinerarios = itinerarios.consultarTodos();
        try {
            JasperByCollectionBeanData.crearPDF(listaItinerarios);
        } catch (JRException ex) {
            Logger.getLogger(PnlBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
