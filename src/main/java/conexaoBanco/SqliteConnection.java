/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jhonatan
 */
public class SqliteConnection {
    private static final String URL = "jdbc:sqlite:src/data/banco.db";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException ex){
            throw new RuntimeException("Erro na conexão com o banco: ", ex);
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar a conexão com o banco 1: ", ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar a conexão com o banco 2: ", ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar a conexão com o banco 3: ", ex);
        }
    }    
}
