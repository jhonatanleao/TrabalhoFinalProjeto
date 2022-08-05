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
import model.Pessoa;

/**
 *
 * @author jhonatan
 */
public class PessoaDao {

    public void create(Pessoa pessoa){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO pessoa (nome, senha, admin, qtdNotificacao) "
                    + "VALUES (?, ?, ?, ?)");
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSenha());
            stmt.setInt(3, pessoa.getAdm());
            stmt.setInt(4, pessoa.getQtdNotificação());
            
            stmt.executeUpdate();

            
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Pessoa> read() {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> listPessoa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();

            while(rs.next()){
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setAdm(rs.getInt("admin"));
                pessoa.setQtdNotificação(rs.getInt("qtdNotificacao"));
 
                //criar o collection de pessoa
                listPessoa.add(pessoa);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listPessoa;
    }    

    
    public void update(Pessoa pessoa){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            //pegar o id do caboco
            //int id = getIdByName(funcionario.getNome());
            
            stmt = con.prepareStatement("UPDATE pessoa SET nome = ?, senha = ?, adm = ?, qtdNotificacao = ? WHERE id = ?");
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSenha());
            stmt.setInt(3, pessoa.getAdm());
            stmt.setInt(4, pessoa.getQtdNotificação());
            stmt.setInt(5, pessoa.getId());


            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }

    public void delete(String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE nome = ?");
            stmt.setString(1, nome);
            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
}
