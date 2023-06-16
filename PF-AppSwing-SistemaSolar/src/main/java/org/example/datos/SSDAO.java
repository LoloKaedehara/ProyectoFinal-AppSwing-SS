package org.example.datos;
import org.example.modelo.SistemaSolar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SSDAO implements Interfaz{
    public SSDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO sistemasolar(Planeta,Luna,Colores,DiasOrbitales,URLimagen) VALUES(?,?,?,?,?)";
        int rowCount = 0;

        PreparedStatement pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((SistemaSolar)obj).getPlaneta());
        pstm.setString(2,((SistemaSolar)obj).getLuna());
        pstm.setString(3,((SistemaSolar)obj).getColores());
        pstm.setInt(4, ((SistemaSolar)obj).getDiasOrbitales());
        pstm.setString(5,((SistemaSolar)obj).getURLimagen());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE sistemasolar SET Planeta = ?, Luna= ?, Colores = ?, DiasOrbitales = ?, URLimagen  = ? WHERE ID = ? ;";
        int rowCount = 0;

        PreparedStatement pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((SistemaSolar) obj).getPlaneta());
        pstm.setString(2, ((SistemaSolar) obj).getLuna());
        pstm.setString(3, ((SistemaSolar) obj).getColores());
        pstm.setInt(4, ((SistemaSolar) obj).getDiasOrbitales());
        pstm.setString(5, ((SistemaSolar) obj).getURLimagen());
        pstm.setInt(6, ((SistemaSolar) obj).getID());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }
    public boolean updateElement(String datoActualizado, int ID, int colIndex) throws SQLException{
        String sqlUpdate;
        PreparedStatement pstm;
        int rowCount;
        switch (colIndex){
            case 1:
                sqlUpdate = "UPDATE sistemasolar SET Planeta = ? Where ID = ? ;";
                rowCount = 0;
                pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 2:
                sqlUpdate = "UPDATE sistemasolar SET Luna = ? Where ID = ? ;";
                rowCount = 0;
                pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 3:
                sqlUpdate = "UPDATE sistemasolar SET Colores = ? Where ID = ? ;";
                rowCount = 0;
                pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 4:
                sqlUpdate = "UPDATE sistemasolar SET DiasOrbitales = ? Where ID = ? ;";
                rowCount = 0;
                pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                pstm.setInt(2,ID);
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 5:
                sqlUpdate = "UPDATE sistemasolar SET URLimagen = ? Where ID = ? ;";
                rowCount = 0;
                pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;

        }
        return false;
    }

    @Override
    public boolean delete(String ID) throws SQLException {
        String sqlDelete = "DELETE FROM sistemasolar WHERE ID = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(ID));
        rowCount = pstm.executeUpdate();
        return rowCount >0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM sistemasolar";
        ArrayList<SistemaSolar> resultado = new ArrayList<>();
        Statement stm = ConexionDB.getInstance("SistemaSolar.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new SistemaSolar(rst.getInt(1), rst.getString(2
            ), rst.getString(3), rst.getString(4),rst.getInt(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorID(String ID) throws SQLException {
        String sqlID = "SELECT * FROM sistemasolar WHERE ID = ? ;";
        SistemaSolar sistemasolar = null;
        PreparedStatement pstm = ConexionDB.getInstance("SistemaSolar.db").getConnection().prepareStatement(sqlID);
        pstm.setInt(1, Integer.parseInt(ID));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            sistemasolar = new SistemaSolar(rst.getInt(1), rst.getString(2
            ), rst.getString(3), rst.getString(4),rst.getInt(5),rst.getString(6));
            return sistemasolar;
        }
        return null;
    }
}