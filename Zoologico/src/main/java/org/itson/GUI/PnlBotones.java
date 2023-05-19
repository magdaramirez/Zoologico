/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.itson.GUI;

import fachadaSistemaImpresion.FachadaSistemaImpresion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IHabitatsDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.utils.JasperByCollectionBeanData;
import org.itson.utils.ModoVentana;

/**
 * Clase que representa un panel con botones en una interfaz de usuario.
 * Extiende de javax.swing.JPanel.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class PnlBotones extends javax.swing.JPanel {

    private final IHabitatsDAO persistencia = null;
    private JTable tabla;
    private JFrame frame;

    /**
     * Constructor de la clase PnlBotones.
     *
     * @param frame El objeto JFrame asociado al panel.
     * @param tabla El objeto JTable asociado al panel.
     */
    public PnlBotones(JFrame frame, JTable tabla) {
        initComponents();
        this.tabla = tabla;
        this.frame = frame;
    }

    public void initEvent(final JFrame frame, final JTable tabla) {
        aBtnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aBtnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aBtnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /**
     * Abre una nueva instancia de la ventana FrmRegistrarItinerario con el modo
     * y el itinerario obtenido a partir de la fila seleccionada en la tabla.
     * Cierra el marco actual después de abrir la nueva ventana.
     *
     * @param modo El modo de la ventana, especificado mediante el enum
     * ModoVentana.
     */
    public void abrirVentana(ModoVentana modo) {
        int fila = tabla.convertRowIndexToModel(tabla.getEditingRow());
        TableModel model = tabla.getModel();
        String nombre = model.getValueAt(fila, 1).toString();
        ConexionMongoDB conexion = new ConexionMongoDB();
        ItinerariosDAO itinerarios = new ItinerariosDAO(conexion);
        Itinerario itinerarioObtenido = itinerarios.obtener(nombre);
        new FrmRegistrarItinerario(modo, itinerarioObtenido).setVisible(true);
        frame.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aBtnActualizar = new org.itson.utils.ActionButton();
        aBtnImprimir = new org.itson.utils.ActionButton();
        aBtnVisualizar = new org.itson.utils.ActionButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        aBtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lapiz (1).png"))); // NOI18N
        aBtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aBtnActualizarActionPerformed(evt);
            }
        });

        aBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora (1).png"))); // NOI18N
        aBtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aBtnImprimirActionPerformed(evt);
            }
        });

        aBtnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo (1).png"))); // NOI18N
        aBtnVisualizar.setBorderPainted(false);
        aBtnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aBtnVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aBtnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aBtnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(aBtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(aBtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Maneja el evento de acción del botón "Imprimir". Obtiene el nombre del
     * itinerario seleccionado en la tabla y realiza la impresión del
     * itinerario.
     *
     * @param evt el evento de acción generado al hacer clic en el botón
     * "Imprimir".
     */
    private void aBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnImprimirActionPerformed
        int fila = tabla.convertRowIndexToModel(tabla.getEditingRow());
        TableModel model = tabla.getModel();
        String nombre = model.getValueAt(fila, 1).toString();
        ConexionMongoDB conexion = new ConexionMongoDB();
        ItinerariosDAO itinerarios = new ItinerariosDAO(conexion);
        Itinerario itinerarioObtenido = itinerarios.obtener(nombre);
        FachadaSistemaImpresion sistemaImpresion = new FachadaSistemaImpresion();
        sistemaImpresion.imprimir(itinerarioObtenido);
    }//GEN-LAST:event_aBtnImprimirActionPerformed
    /**
     * Maneja el evento de acción del botón "Visualizar". Abre la ventana en
     * modo de previsualización.
     *
     * @param evt el evento de acción generado al hacer clic en el botón
     * "Visualizar".
     */
    private void aBtnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnVisualizarActionPerformed
        abrirVentana(ModoVentana.PREVISUALIZAR);
    }//GEN-LAST:event_aBtnVisualizarActionPerformed
    /**
     * Maneja el evento de acción del botón "Actualizar". Abre la ventana en
     * modo de actualización.
     *
     * @param evt el evento de acción generado al hacer clic en el botón
     * "Actualizar".
     */
    private void aBtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnActualizarActionPerformed
        abrirVentana(ModoVentana.ACTUALIZAR);
    }//GEN-LAST:event_aBtnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.itson.utils.ActionButton aBtnActualizar;
    private org.itson.utils.ActionButton aBtnImprimir;
    private org.itson.utils.ActionButton aBtnVisualizar;
    // End of variables declaration//GEN-END:variables
}
