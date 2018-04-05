package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estudante;
import util.ConnectionJDBC;

public class EstudanteDAO {

    Connection connection;

    public EstudanteDAO() throws Exception {
        //Obtém uma conexão
        connection = ConnectionJDBC.getConnection();
    }
    public void save(Estudante estudante) throws Exception {
        String SQL = "INSERT INTO ESTUDANTE(NOME, CURSO, DATA_MATRICULA, STATUS) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            //p.setInt(1, autor.getAutor_id());
            p.setString(1, estudante.getNome());
            p.setString(2, estudante.getCurso());
            p.setDate(3, estudante.getData());
            p.setString(4, estudante.getStatus());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    public void update(Estudante estudante) throws Exception {
        String SQL = "UPDATE ESTUDANTE SET NOME=?, CURSO=?, DATA_MATRICULA=?, STATUS=? WHERE ESTUDANTE_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, estudante.getNome());
            p.setString(2, estudante.getCurso());
            p.setDate(3, estudante.getData());
            p.setString(4, estudante.getStatus());
            p.setInt(5, estudante.getEstudante_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    public void delete(Estudante estudante) throws Exception {
        String SQL = "DELETE FROM ESTUDANTE WHERE ESTUDANTE_ID=?";
        PreparedStatement p;
        try {
            p = connection.prepareStatement(SQL);
            p.setInt(1, estudante.getEstudante_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    public Estudante findById(int id) {
        return new Estudante();
    }

    public List<Estudante> findAll() throws Exception {
        List<Estudante> list = new ArrayList<>();
        Estudante objeto;
        String SQL = "SELECT * FROM ESTUDANTE ORDER BY ESTUDANTE_ID";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                objeto = new Estudante();
                objeto.setEstudante_id(rs.getInt("editora_id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setCurso(rs.getString("curso"));
                objeto.setData(rs.getDate("data"));
                objeto.setStatus(rs.getString("status"));
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
