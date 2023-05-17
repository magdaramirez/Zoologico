/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.zoologico;

//import java.util.ArrayList;
//import java.util.Arrays;
import org.itson.GUI.FrmInicio;
//import org.itson.dominio.Habitat;
//import org.itson.dominio.Zona;
//import org.itson.interfaces.IGuiaDAO;
//import org.itson.interfaces.IHabitatsDAO;
//import org.itson.interfaces.IItinerariosDAO;
//import org.itson.interfaces.IZonasDAO;
import org.itson.persistencia.ConexionMongoDB;
//import org.itson.persistencia.GuiaDAO;
//import org.itson.persistencia.HabitatsDAO;
//import org.itson.persistencia.ItinerariosDAO;
//import org.itson.persistencia.ZonasDAO;

/**
 * Clase principal.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //CONEXIÓN A LA BASE DE DATOS
//        ConexionMongoDB conexion = new ConexionMongoDB();
//        IHabitatsDAO habitatsDAO = new HabitatsDAO(conexion);
//        IZonasDAO zonasDAO = new ZonasDAO(conexion);
//        IItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
//        IGuiaDAO GuiaDAO = new GuiaDAO(conexion);
//        GuiaDAO.insertarGuia();
//
//        //INSERCIÓN DE HABITATS
//        Habitat habitat1 = new Habitat();
//        habitat1.setNombre("Aviario");
//        habitatsDAO.agregar(habitat1);
//
//        Habitat habitat2 = new Habitat();
//        habitat2.setNombre("Acuario");
//        habitatsDAO.agregar(habitat2);
//
//        Habitat habitat3 = new Habitat();
//        habitat3.setNombre("Terrario");
//        habitatsDAO.agregar(habitat3);
//
//        Habitat habitat4 = new Habitat();
//        habitat4.setNombre("Granja");
//        habitatsDAO.agregar(habitat4);
//
//        Habitat habitat5 = new Habitat();
//        habitat5.setNombre("Africano");
//        habitatsDAO.agregar(habitat5);
//
//        Habitat habitat6 = new Habitat();
//        habitat6.setNombre("del Amazonas");
//        habitatsDAO.agregar(habitat6);
//
//        Habitat habitat7 = new Habitat();
//        habitat7.setNombre("de Madagascar");
//        habitatsDAO.agregar(habitat7);
//
//        Habitat habitat8 = new Habitat();
//        habitat8.setNombre("Reptilia");
//        habitatsDAO.agregar(habitat8);
//
//        Habitat habitat9 = new Habitat();
//        habitat9.setNombre("Desertico");
//        habitatsDAO.agregar(habitat9);
//
//        Habitat habitat10 = new Habitat();
//        habitat10.setNombre("Bosque");
//        habitatsDAO.agregar(habitat10);
//
//        Habitat habitat11 = new Habitat();
//        habitat11.setNombre("Polar");
//        habitatsDAO.agregar(habitat11);
//
//        //Insercción de zonas
//        Zona zona1 = new Zona("Aves", new ArrayList<>(Arrays.asList(habitat1)));
//
//        Zona zona2 = new Zona("Acuaticos", new ArrayList<>(Arrays.asList(habitat2)));
//
//        Zona zona3 = new Zona("Praderas", new ArrayList<>(Arrays.asList(habitat3, habitat4)));
//
//        Zona zona4 = new Zona("Savana", new ArrayList<>(Arrays.asList(habitat5, habitat7)));
//
//        Zona zona5 = new Zona("Selva", new ArrayList<>(Arrays.asList(habitat6)));
//
//        Zona zona6 = new Zona("Exotico", new ArrayList<>(Arrays.asList(habitat8)));
//
//        Zona zona7 = new Zona("Entorno arido", new ArrayList<>(Arrays.asList(habitat9)));
//
//        Zona zona8 = new Zona("Forestal", new ArrayList<>(Arrays.asList(habitat10)));
//
//        Zona zona9 = new Zona("Artico", new ArrayList<>(Arrays.asList(habitat11)));
//
//        zonasDAO.agregar(zona1);
//        zonasDAO.agregar(zona2);
//        zonasDAO.agregar(zona3);
//        zonasDAO.agregar(zona4);
//        zonasDAO.agregar(zona5);
//        zonasDAO.agregar(zona6);
//        zonasDAO.agregar(zona7);
//        zonasDAO.agregar(zona8);
//        zonasDAO.agregar(zona9);
//
//        zona1.setDirecciones(Arrays.asList(zona4.getId(), zona2.getId(), null, null));
//        zona2.setDirecciones(Arrays.asList(zona5.getId(), zona3.getId(), null, zona1.getId()));
//        zona3.setDirecciones(Arrays.asList(zona6.getId(), null, null, zona2.getId()));
//        zona4.setDirecciones(Arrays.asList(zona7.getId(), zona5.getId(), zona1.getId(), null));
//        zona5.setDirecciones(Arrays.asList(zona8.getId(), zona6.getId(), zona2.getId(), zona4.getId()));
//        zona6.setDirecciones(Arrays.asList(zona9.getId(), null, zona3.getId(), zona5.getId()));
//        zona7.setDirecciones(Arrays.asList(null, zona8.getId(), zona4.getId(), null));
//        zona8.setDirecciones(Arrays.asList(null, zona9.getId(), zona5.getId(), zona7.getId()));
//        zona9.setDirecciones(Arrays.asList(null, null, zona6.getId(), zona8.getId()));
//
//        zonasDAO.actualizar(zona1);
//        zonasDAO.actualizar(zona2);
//        zonasDAO.actualizar(zona3);
//        zonasDAO.actualizar(zona4);
//        zonasDAO.actualizar(zona5);
//        zonasDAO.actualizar(zona6);
//        zonasDAO.actualizar(zona7);
//        zonasDAO.actualizar(zona8);
//        zonasDAO.actualizar(zona9);

        //INSERCIÓN DE ITINERARIOS
        /*Itinerario itinerario1 = new Itinerario();
        itinerario1.setNombre("Prueba");
        itinerario1.setDuracion(40);
        itinerario1.setLongitud(35.6f);
        itinerario1.setNoVisitantes(24);
        itinerariosDAO.agregar(itinerario1);*/

 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });

    }
}
