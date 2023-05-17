/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.itson.GUI;

import org.itson.interfaces.ITableActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.interfaces.IHabitatsDAO;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class PnlBotones extends javax.swing.JPanel {

    private final IHabitatsDAO persistencia = null;
    
    /**
     * Creates new form PanelAction
     */
    public PnlBotones() {
        initComponents();
    }

    public void initEvent(ITableActionEvent event, int row) {
        aBtnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        aBtnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        aBtnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    /**
     * Método que despliega FrmActualizarItinerario.
     */
    public void abrirVentanaActualizar() {
        new FrmActualizarItinerario(this.persistencia).setVisible(true);
    }

    /**
     * Método que despliega FrmPrevisualizarItinerario.
     */
    public void abrirVentanaPrevisualizar() {
        FrmPrevisualizarItinerario previsualizarItinerario = new FrmPrevisualizarItinerario();
        previsualizarItinerario.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aBtnActualizar = new org.itson.utils.ActionButton();
        aBtnImprimir = new org.itson.utils.ActionButton();
        aBtnVisualizar = new org.itson.utils.ActionButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

    private void aBtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnActualizarActionPerformed
        abrirVentanaActualizar();
    }//GEN-LAST:event_aBtnActualizarActionPerformed

    private void aBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aBtnImprimirActionPerformed

    private void aBtnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnVisualizarActionPerformed
        abrirVentanaPrevisualizar();
    }//GEN-LAST:event_aBtnVisualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.itson.utils.ActionButton aBtnActualizar;
    private org.itson.utils.ActionButton aBtnImprimir;
    private org.itson.utils.ActionButton aBtnVisualizar;
    // End of variables declaration//GEN-END:variables
}
