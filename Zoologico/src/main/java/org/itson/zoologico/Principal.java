/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.zoologico;

import org.bson.Document;
import org.itson.GUI.FrmInicio;
import org.itson.dominio.Habitat;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IGuiaDAO;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.interfaces.IItinerariosDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.GuiaDAO;
import org.itson.persistencia.HabitatsDAO;
import org.itson.persistencia.ItinerariosDAO;

/**
 *
 * @author magda
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //CONEXIÓN A LA BASE DE DATOS
        ConexionMongoDB conexion = new ConexionMongoDB();
        //IHabitatsDAO habitatsDAO = new HabitatsDAO(conexion);
        IItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        IGuiaDAO GuiaDAO = new GuiaDAO(conexion);
        GuiaDAO.insertarGuia();

        /* //INSERCIÓN DE HABITATS
        Habitat habitat1 = new Habitat();
        habitat1.setNombre("Aviario");
        habitatsDAO.agregar(habitat1);

        Habitat habitat2 = new Habitat();
        habitat2.setNombre("Acuario");
        habitatsDAO.agregar(habitat2);
        
        Habitat habitat3 = new Habitat();
        habitat3.setNombre("Terrario");
        habitatsDAO.agregar(habitat3);

        Habitat habitat4 = new Habitat();
        habitat4.setNombre("Granja");
        habitatsDAO.agregar(habitat4);
        
        Habitat habitat5 = new Habitat();
        habitat5.setNombre("Africano");
        habitatsDAO.agregar(habitat5);
        
        Habitat habitat6 = new Habitat();
        habitat6.setNombre("del Amazonas");
        habitatsDAO.agregar(habitat6);

        Habitat habitat7 = new Habitat();
        habitat7.setNombre("de Madagascar");
        habitatsDAO.agregar(habitat7);*/
        
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
