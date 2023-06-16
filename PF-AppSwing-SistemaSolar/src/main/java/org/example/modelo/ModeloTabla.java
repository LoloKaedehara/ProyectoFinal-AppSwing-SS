package org.example.modelo;
import org.example.datos.ConexionDB;
import org.example.datos.Interfaz;
import org.example.datos.SSDAO;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTabla implements TableModel {
    private ArrayList<SistemaSolar> datos;
    public static final int COLUMNAS = 6;
    private SSDAO ssdao;
    public ModeloTabla(){
        ssdao = new SSDAO();
        datos = new ArrayList<>();
    }
    public ModeloTabla(ArrayList<SistemaSolar> datos){
        this.datos = datos;
    }
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "ID";
            case 1:
                return "Planeta";
            case 2:
                return "Luna";
            case 3:
                return "Color";
            case 4:
                return "Dias Orbitales";
            case 5:
                return "URLimagen";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SistemaSolar tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getPlaneta();
            case 2:
                return tmp.getLuna();
            case 3:
                return tmp.getColores();
            case 4:
                return tmp.getDiasOrbitales();
            case 5:
                return tmp.getURLimagen();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                datos.get(rowIndex).getID();
                break;
            case 1:
                datos.get(rowIndex).setPlaneta((String)o);
                break;
            case 2:
                datos.get(rowIndex).setLuna((String)o);
                break;
            case 3:
                datos.get(rowIndex).setColores((String)o);
                break;
            case 4:
                datos.get(rowIndex).setDiasOrbitales((int)o);
                break;
            case 5:
                datos.get(rowIndex).setURLimagen((String)o);
                break;
            default:
                System.out.println("No se modifico nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {


    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }


    public void cargarDatos(){
        try {
            ArrayList<SistemaSolar> girar = ssdao.obtenerTodo();
            System.out.println(girar);
            datos = ssdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    public boolean agregarSistemaSolar (SistemaSolar sistemaSolar){
        boolean resultado = false;
        try{
            if(ssdao.insertar(sistemaSolar)){
                datos.add(sistemaSolar);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public SistemaSolar getSistemaSolarAtIndex(int idx){
        return datos.get(idx);
    }

    public boolean actualizarSistemaSolar (SistemaSolar sistemaSolar){
        try {
            return ssdao.update(sistemaSolar);
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            return true;
        }
    }
    public boolean actualizarElemento(String datoActualizado, int id, int colIndex) throws SQLException{
        if(ssdao.updateElement(datoActualizado, id, colIndex)){
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarSistemaSolar(String ID){
        try {
            String sqlDelete = "DELETE FROM sistemasolar WHERE ID = ?;";
            int rowCount = 0;
            PreparedStatement pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlDelete);
            pstm.setInt(1,Integer.parseInt(ID));
            rowCount = pstm.executeUpdate();

            return rowCount >0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;

        }
    }


}
