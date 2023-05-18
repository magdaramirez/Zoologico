/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.objetosnegocio.Horario;
import org.itson.objetosnegocio.Itinerario;


/**
 *
 * @author march
 */
public class JasperByCollectionBeanData {

    /**
     * Logger.
     */
    private static final Logger LOG
            = Logger.getLogger(JasperByCollectionBeanData.class.getName());

    private JasperByCollectionBeanData() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Método que abre una ventana con la tabla en un archivo de tipo PDF.
     *
     * @param listaItinerarios Itinerarios que se quieren visualizar en el PDF.
     * @throws JRException Excepción que aparece cuando no se logra realizar el
     * procedimiento.
     */
    public static void crearPDF(final List<Itinerario> listaItinerarios) throws JRException {
        Set<String> diasUnicos = new HashSet<>();

        // Obtener los días únicos de los itinerarios
        for (Itinerario itinerario : listaItinerarios) {
            for (Horario horario : itinerario.getListaHorarios()) {
                diasUnicos.add(horario.getDia());
            }
        }

        // Crear una nueva lista de itinerarios con los días únicos
        List<Itinerario> listaItinerariosUnicos = new ArrayList<>();
        for (Itinerario itinerario : listaItinerarios) {
            List<Horario> horariosUnicos = new ArrayList<>();
            for (Horario horario : itinerario.getListaHorarios()) {
                if (diasUnicos.contains(horario.getDia())) {
                    horariosUnicos.add(horario);
                    diasUnicos.remove(horario.getDia());
                }
            }
            Itinerario itinerarioUnico = new Itinerario(itinerario.getNombre(), itinerario.getDuracion(), itinerario.getNoVisitantes(), horariosUnicos);
            listaItinerariosUnicos.add(itinerarioUnico);
        }

        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaItinerariosUnicos);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CollectionBeanParam", itemsJRBean);

        try {
            String rutaInput = "src\\main\\resources\\pdfs\\reporteZoo.jrxml";
            InputStream input = new FileInputStream(new File(rutaInput));

            JasperDesign jasperDesign = JRXmlLoader.load(input);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            JasperViewer.viewReport(jasperPrint, false);
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

}
