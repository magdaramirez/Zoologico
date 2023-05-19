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
 * Clase que contiene la lógica de la ventana de inicio.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class LogicaInicio {

    private JFrame frame;

    /**
     * Constructor de la clase LogicaInicio.
     *
     * @param frame El JFrame principal de la ventana de inicio.
     */
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

    /**
     * Abre la ventana de registro de itinerarios con el modo especificado. Crea
     * una instancia de la clase FrmRegistrarItinerario con el modo y null como
     * argumentos y la hace visible. Luego, cierra la ventana actual de la
     * aplicación.
     *
     * @param modo El modo de ventana para la ventana de registro de
     * itinerarios.
     */
    public void abrirVentanaRegistro(ModoVentana modo) {
        new FrmRegistrarItinerario(modo, null).setVisible(true);
        frame.dispose();
    }

}
