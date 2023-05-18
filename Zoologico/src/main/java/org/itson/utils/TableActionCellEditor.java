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
    
    public TableActionCellEditor(JFrame frame) {
        super(new JCheckBox());
        this.frame = frame;
    }

    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PnlBotones action = new PnlBotones(frame, table);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
