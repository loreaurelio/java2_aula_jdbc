package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private static Connection connection;

    public static Connection getConnection() throws Exception {

        if (connection == null) {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex) {
                throw new Exception(ex);
            }
            String servidor = "localhost";
            String database = "C:\\Users\\Loren\\OneDrive\\Documentos\\Técnico\\bd\\AULA06.fdb";
            String user = "SYSDBA";
            String password = "masterkey";
            String url = "jdbc:firebirdsql:" + servidor + "/3050:" + database + "?encoding=win1252";
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                throw new Exception(ex);
            }
        }
        return connection;
    }
    
    public static void main(String[] args) {
        System.out.println("Teste!");
        try {
            ConnectionJDBC.getConnection();
        } catch (Exception ex) {
            System.out.println(""+ex.getMessage());
        }
    }
}
