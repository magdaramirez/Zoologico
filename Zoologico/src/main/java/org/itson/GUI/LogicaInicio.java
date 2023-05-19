/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.itson.utils.ModoVentana;

/**
 *
 * @author wikit
 */
public class LogicaInicio {

    private JFrame frame;

    public LogicaInicio(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Método que despliega FrmItinerarios.
     */
    public void abrirVentanaItinerarios() {
        FrmItinerarios frmItinerarios = new FrmItinerarios();
        frmItinerarios.setVisible(true);
        frame.dispose();
    }

    /**
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
    }

    /**
     * Método que establece el color del fondo de un JPanel.
     *
     * @param panel JPanel cuyo color de fondo va a cambiar.
     * @param color Color a poner de fondo.
     */
    public void cambiarColorPanel(JPanel panel, Color color) {
        panel.setBackground(color);
    }

    /**
     * Método que establece el color de letra de un JLabel.
     *
     * @param label JLabel cuyo color de letra va a cambiar.
     * @param color Color a poner en la letra.
     */
    public void cambiarColorLetra(JLabel label, Color color) {
        label.setForeground(color);
    }

    /**
     * Método que esteblece el borde de un JPanel.
     *
     * @param panel JPanel cuyo borde va a cambiar.
     * @param border Borde a poner en el panel.
     */
    public void cambiarBordePanel(JPanel panel, Border border) {
        panel.setBorder(border);
    }

    public void abrirVentanaRegistro(ModoVentana modo) {
        new FrmRegistrarItinerario(modo, null).setVisible(true);
        frame.dispose();
    }

}
