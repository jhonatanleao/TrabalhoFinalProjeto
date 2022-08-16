/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoBanco.SqliteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proxy.ImagemProxy;

/**
 *
 * @author jhonatan
 */
public class ImagemDao {

    public int create(String caminho){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{           
            stmt = con.prepareStatement("INSERT INTO imagem (caminho) VALUES (?)");
            stmt.setString(1, caminho);

            stmt.executeUpdate();

            
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
        return 1;
    }
    
    public List<ImagemProxy> read() {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id;
        String caminho;
        
        List<ImagemProxy> listImagem = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM imagem");
            rs = stmt.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                

                id = rs.getInt("id");
                caminho = rs.getString("caminho");
                ImagemProxy imagem = new ImagemProxy(id, caminho);
                listImagem.add(imagem);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listImagem;
    }  
}
