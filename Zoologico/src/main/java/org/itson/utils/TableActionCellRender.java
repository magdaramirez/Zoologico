/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.itson.GUI.PnlBotones;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class TableActionCellRender extends DefaultTableCellRenderer{

    JFrame frame;
    
    /**
     * Método que obtiene el componente de la acción del botón seleccionado.
     * @param table Tabla donde se encuentra el botón.
     * @param value Valor del objeto.
     * @param isSelected Booleano que indica si fue seleccionado.
     * @param hasFocus Booleano que ifentifica si tiene focus.
     * @param row Fila donde se encuentra el botón.
     * @param column Columna donde se encuentra el botón.
     * @return Componente de acción de botón seleccionado.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp=  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        PnlBotones action = new PnlBotones(frame, table);
        action.setBackground(comp.getBackground());
        return action;
    }
 

}
