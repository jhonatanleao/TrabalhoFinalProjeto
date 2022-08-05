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
import model.Notificacao;

/**
 *
 * @author jhonatan
 */
public class NotificacaoDao {

    public void create(Notificacao notificacao){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO notificacao (idPessoa, txtNotificacao) "
                    + "VALUES (?, ?)");
            stmt.setInt(1, notificacao.getIdPessoa());
            stmt.setString(2, notificacao.getConteudoNot());
            
            stmt.executeUpdate();
           
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Notificacao> read() {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Notificacao> listPessoa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM notificacao");
            rs = stmt.executeQuery();

            while(rs.next()){
                Notificacao notificacao = new Notificacao();

                notificacao.setId(rs.getInt("id"));
                notificacao.setIdPessoa(rs.getInt("idPessoa"));
                notificacao.setConteudoNot(rs.getString("txtNotificacao"));

                //criar o collection de notificacao
                listPessoa.add(notificacao);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listPessoa;
    }    

    public void delete(int idPessoa){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM notificacao WHERE idPessoa = ?");
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }  
}
