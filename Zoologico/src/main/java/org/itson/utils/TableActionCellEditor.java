/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import org.itson.GUI.PnlBotones;

/**
 *
 * @author Magda Ramírez - 233523, Misael Marchena - 233418, Ildefonso Lares -
 * 233381, Esteban Duran - 233267
 */
public class TableActionCellEditor extends DefaultCellEditor {

    JFrame frame;
    
    /**
     * Método constructor que inicializa el frame donde se utilizarán los botones dentro de una tabla.
     * @param frame Frame donde estarán los botones dentro de una tabla.
     */
    public TableActionCellEditor(JFrame frame) {
        super(new JCheckBox());
        this.frame = frame;
    }

    
    /**
     * Método que obtiene la acción del botón.
     * @param table Tabla donde están los botones.
     * @param value Valor de objeto.
     * @param isSelected Booleano que indica si fue seleccionando.
     * @param row Fila donde se encuentra el botón seleccionado.
     * @param column Columna donde se encuentra el botón seleccionado.
     * @return La acción del botón.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PnlBotones action = new PnlBotones(frame, table);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
