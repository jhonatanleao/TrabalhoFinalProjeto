/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Util.ProcessaString;
import conexaoBanco.SqliteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pessoa.Pessoa;

/**
 *
 * @author jhonatan
 */
public class PessoaDao {
    
    public int eVazio(){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int contador=0;

        try{           
            stmt = con.prepareStatement("SELECT COUNT(id) FROM pessoa");
            rs = stmt.executeQuery();
            contador = rs.getInt("COUNT(id)");
            
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
        return contador;
    }

    public int create(Pessoa pessoa){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            
            if(this.verificaNome(pessoa.getNome()) == 0){
                int verificador = this.eVazio();
                if(verificador == 0){
                    pessoa.setAdm(1);
                } 
                stmt = con.prepareStatement("INSERT INTO pessoa (nome, senha, admin, qtdNotificacao, notificacoes, permissoes) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, pessoa.getSenha());
                stmt.setInt(3, pessoa.getAdm());
                stmt.setInt(4, pessoa.getQtdNotificação());
                
                ProcessaString prossamento = new ProcessaString();               
                stmt.setString(5, prossamento.compila(pessoa.getNotificacao()));
                stmt.setString(6, prossamento.compila(pessoa.getPermissoes()));

                stmt.executeUpdate();
            } else {
                return 0;
                //criar um option pane para falar que ja existe uma pessoa com aquele nome
            }
            
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
        return 1;
    }
    
    
    
    public List<Pessoa> read() {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> listPessoa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setAdm(rs.getInt("admin"));
                pessoa.setQtdNotificação(rs.getInt("qtdNotificacao"));
                ProcessaString prossamento = new ProcessaString();
                pessoa.setNotificacao(prossamento.descompila(rs.getString("notificacoes")));
                pessoa.setPermissoes(prossamento.descompila(rs.getString("permissoes"))); 
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
 
    public int verificaNome(String nome) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int contador=0;

        try {           
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            contador = rs.getInt("id");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return contador;
    } 
    
    public Pessoa readByName(String nome) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = new Pessoa();

        try {
            
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            System.out.println(rs.getString("nome"));
            
            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setSenha(rs.getString("senha"));
            pessoa.setAdm(rs.getInt("admin"));
            pessoa.setQtdNotificação(rs.getInt("qtdNotificacao"));
            ProcessaString prossamento = new ProcessaString();
            pessoa.setNotificacao(prossamento.descompila(rs.getString("notificacoes")));
            pessoa.setPermissoes(prossamento.descompila(rs.getString("permissoes")));

            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return pessoa;
    } 

    
    public void update(Pessoa pessoa){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            //pegar o id do caboco
            //int id = getIdByName(funcionario.getNome());
            
            stmt = con.prepareStatement("UPDATE pessoa SET nome = ?, senha = ?, admin = ?, qtdNotificacao = ?, notificacoes = ?, permissoes = ? WHERE id = ?");
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSenha());
            stmt.setInt(3, pessoa.getAdm());
            stmt.setInt(4, pessoa.getQtdNotificação());
            stmt.setInt(7, pessoa.getId());

            ProcessaString prossamento = new ProcessaString();               
            stmt.setString(5, prossamento.compila(pessoa.getNotificacao()));
            stmt.setString(6, prossamento.compila(pessoa.getPermissoes()));
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
