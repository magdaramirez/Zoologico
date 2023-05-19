/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IGuiaDAO;
import org.itson.interfaces.IItinerariosDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.GuiaDAO;
import org.itson.persistencia.ItinerariosDAO;
import org.itson.utils.ModoVentana;
import org.itson.utils.TableActionCellEditor;
import org.itson.utils.TableActionCellRender;

/**
 * Clase que contiene la lógica de la ventana de itinerarios.
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class LogicaItinerarios {

    private final JFrame frame;
    private final ConexionMongoDB conexion = new ConexionMongoDB();
    private final IGuiaDAO persistenciaGuia;
    private final IItinerariosDAO persistenciaItinerario;

    private int contador = 1;

    /**
     * Constructor de la clase LogicaItinerarios.
     *
     * @param frame El JFrame principal de la ventana de itinerarios.
     */
    public LogicaItinerarios(JFrame frame) {
        this.frame = frame;
        persistenciaGuia = new GuiaDAO(conexion);
        persistenciaItinerario = new ItinerariosDAO(conexion);
    }

    /**
     * Configura la apariencia y el comportamiento de la tabla especificada.
     * Establece el renderizador y el editor de celdas para la columna 5 de la
     * tabla como TableActionCellRender y TableActionCellEditor respectivamente.
     * Cambia la fuente, el color de fondo y el alto de las filas de la tabla.
     *
     * @param table La tabla a configurar.
     */
    public void configurarTabla(JTable table) {
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(frame));

        table.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setForeground(new Color(102, 0, 0));
        table.setRowHeight(40);
    }

    /**
     * Inserta los datos del formulario de guía en la etiqueta especificada.
     * Obtiene el nombre de la guía a través de la persistenciaGuia y lo
     * establece como el texto de la etiqueta.
     *
     * @param label La etiqueta donde se mostrará el nombre de la guía.
     */
    public void insertarDatosFormularioGuia(JLabel label) {
        label.setText(persistenciaGuia.obtenerGuia().getNombre());
    }

    /**
     * Obtiene los itinerarios desde la persistencia. Si no se encuentran
     * itinerarios, redirige al usuario a la ventana de registro de itinerarios.
     *
     * @return true si se obtienen los itinerarios exitosamente, false si no
     * existen itinerarios y se redirige al usuario.
     */
    public boolean obtenerItinerarios() {
        if (!persistenciaItinerario.obtenerItinerarios()) {
            // La colección no existe
            //JOptionPane.showMessageDialog(frame, "No existen colecciones disponibles.", "Error", JOptionPane.ERROR_MESSAGE);

            // Redirigir al usuario a la ventana FrmRegistrarItinerario
            abrirVentanaRegistro();
            return false;
        }
        return true;
    }

    /**
     * Método que despliega FrmRegistrarItinerario.
     */
    public void abrirVentanaRegistro() {
        new FrmRegistrarItinerario(ModoVentana.REGISTRAR, null).setVisible(true);
        frame.dispose();
    }

    /**
     * Llena la tabla de itinerarios con los datos obtenidos desde la base de
     * datos.
     *
     * @param table la tabla de itinerarios a llenar.
     */
    public void llenarTablaItinerarios(JTable table) {
        // CONEXIÓN A LA BASE DE DATOS
        ConexionMongoDB conexion = new ConexionMongoDB();
        IItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        // Consultar itinerarios
        List<Itinerario> itinerarios = itinerariosDAO.consultarTodos();

        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0);
        for (Itinerario itinerario : itinerarios) {
            // Obtener la lista de días únicos del itinerario
            List<String> diasUnicos = itinerario.getListaHorarios().stream()
                    .map(Horario::getDia)
                    .distinct()
                    .collect(Collectors.toList());

            // Convertir la lista de días en una cadena separada por comas
            String dias = String.join(", ", diasUnicos);

            Object[] fila = {
                contador++,
                itinerario.getNombre(),
                itinerario.getDuracion(),
                itinerario.getNoVisitantes(),
                dias
            };
            modelo.addRow(fila);
        }
    }

    /**
     * Método que termina el programa.
     */
    public void salirDelPrograma() {
        System.exit(0);
    }

    /**
     * Método que regresa a FrmInicio.
     */
    public void regresarVentanaInicio() {
        FrmInicio inicio = new FrmInicio();
        inicio.setVisible(true);
        frame.dispose();
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
     * Método que establece un ícono a un JLabel.
     *
     * @param label JLabel cuyo ícono será establecido.
     * @param icono Ícono a establecer.
     */
    public void cambiarIcono(JLabel label, String icono) {
        label.setIcon(new ImageIcon(icono));
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

}
