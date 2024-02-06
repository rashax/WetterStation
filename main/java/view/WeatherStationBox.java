package Wetterstation;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;

public class WeatherStationBox extends JPanel {

    final JTable table;

    public WeatherStationBox() {
        super();


        table = new JTable(10, 3);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.setShowGrid(true);
        table.setGridColor(Color.black);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setRowSelectionInterval(0, 0);
        table.setRowHeight(30);
        table.setFont(new Font("Calibri", Font.PLAIN, 14));
        table.setSelectionBackground(new Color(0xCEE1DF));
        table.setSelectionForeground(Color.black);
        table.setBackground(new Color(0xEEFFFA));
        table.setBorder(BorderFactory.createBevelBorder(2));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 14));
        table.getTableHeader().setBackground(new Color(0xEEFFFA));
        table.getTableHeader().setBorder(BorderFactory.createBevelBorder(2));

        table.prepareRenderer(table.getCellRenderer(0, 0), 0, 0);

        table.add(new Scrollbar(Scrollbar.VERTICAL));
        table.scrollRectToVisible(new Rectangle(table.getCellRect(7, 2, true)));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        add(table);

        setBounds(0, 60, WIDTH, 500);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void RefreshTable() {

        rendererTable();
        table.revalidate();
        table.repaint();
    }

    private void rendererTable() {

        table.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                return 10;//model.getWeatherStations().size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public String getColumnName(int columnIndex) {

                return switch (columnIndex) {
                    case 0 -> "Station";
                    case 1 -> "Nr";
                    case 2 -> "Temperatur";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return null;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }

            @Override
            public void addTableModelListener(TableModelListener l) {

            }

            @Override
            public void removeTableModelListener(TableModelListener l) {

            }
        });
    }

//    private class WeatherStationTableModel implements TableModel {
//        @Override
//        public int getRowCount() {
//            return 0;
//        }
//
//        @Override
//        public int getColumnCount() {
//            return 0;
//        }
//
//        @Override
//        public String getColumnName(int columnIndex) {
//            return null;
//        }
//
//        @Override
//        public Class<?> getColumnClass(int columnIndex) {
//            return null;
//        }
//
//        @Override
//        public boolean isCellEditable(int rowIndex, int columnIndex) {
//            return false;
//        }
//
//        @Override
//        public Object getValueAt(int rowIndex, int columnIndex) {
//            return null;
//        }
//
//        @Override
//        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//
//        }
//
//        @Override
//        public void addTableModelListener(TableModelListener l) {
//
//        }
//
//        @Override
//        public void removeTableModelListener(TableModelListener l) {
//
//        }
//    }
}