/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jhonatan
 */
public class Pessoa {
    private int id;
    private String nome;
    private String senha;
    private int adm;
    private int qtdNotificacao;

    public Pessoa(String nome, String senha, int adm) {
        this.id = 0;
        this.nome = nome;
        this.senha = senha;
        this.adm = adm;
        this.qtdNotificacao = 0;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAdm() {
        return adm;
    }

    public void setAdm(int adm) {
        this.adm = adm;
    }

    public int getQtdNotificação() {
        return qtdNotificacao;
    }

    public void setQtdNotificação(int qtdNotificacao) {
        this.qtdNotificacao = qtdNotificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
