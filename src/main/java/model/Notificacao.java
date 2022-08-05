/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jhonatan
 */
public class Notificacao {
    private int id;
    private int idPessoa;
    private String conteudoNot;

    public Notificacao(int idPessoa, String conteudoNot) {
        this.id = 0;
        this.idPessoa = idPessoa;
        this.conteudoNot = conteudoNot;
    }

    public Notificacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getConteudoNot() {
        return conteudoNot;
    }

    public void setConteudoNot(String conteudoNot) {
        this.conteudoNot = conteudoNot;
    }
    
    
}
