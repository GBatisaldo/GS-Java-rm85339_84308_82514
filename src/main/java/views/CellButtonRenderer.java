package main.java.views;

import main.java.listeners.TableButtonListener;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Vector;

public class CellButtonRenderer extends JButton implements TableCellRenderer, TableCellEditor {
    Long selectedId;
    Vector<TableButtonListener> listener;

    public CellButtonRenderer(String text) {
        super(text);
        listener = new Vector<>();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(TableButtonListener l : listener) {
                    l.tableButtonClicked(selectedId);
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
    ) {
        return this;
    }

    public void addTableButtonListener(TableButtonListener l) {
        listener.add(l);
    }

    public void removeTableButtonListener( TableButtonListener l ) {
        listener.remove(l);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        selectedId = Long.valueOf((String)value);
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {

    }
}
