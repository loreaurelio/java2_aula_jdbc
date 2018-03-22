package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Editora;
import util.ConnectionJDBC;

public class EditoraDAO {

    Connection connection;

    public EditoraDAO() throws Exception {
        //Obtém uma conexão
        connection = ConnectionJDBC.getConnection();
    }

    public void save(Editora editora) throws Exception {
        String SQL = "INSERT INTO EDITORA(NOME, MUNICIPIO) VALUES (?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            //p.setInt(1, autor.getAutor_id());
            p.setString(1, editora.getNome());
            p.setString(2, editora.getMunicipio());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Editora editora) throws Exception {
        String SQL = "UPDATE EDITORA SET NOME=?, MUNICIPIO=? WHERE EDITORA_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, editora.getNome());
            p.setString(2, editora.getMunicipio());
            p.setInt(3, editora.getEditora_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Editora editora) throws Exception {
        String SQL = "DELETE FROM EDITORA WHERE EDITORA_ID=?";
        PreparedStatement p;
        try {
            p = connection.prepareStatement(SQL);
            p.setInt(1, editora.getEditora_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public Editora findById(int id) {
        return new Editora();
    }

    public List<Editora> findAll() throws Exception {
        List<Editora> list = new ArrayList<>();
        Editora objeto;
        String SQL = "SELECT * FROM EDITORA ORDER BY EDITORA_ID";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                objeto = new Editora();
                objeto.setEditora_id(rs.getInt("editora_id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setMunicipio(rs.getString("municipio"));
                list.add(objeto);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        return list;
    }
}
