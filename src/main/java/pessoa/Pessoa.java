/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pessoa;

import java.util.HashSet;
import java.util.Set;

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
    private Set<String> notificacao;
    private Set<String> permissoes;

    public Pessoa(String nome, String senha) {
        this.id = 0;
        this.nome = nome;
        this.senha = senha;
        this.adm = 0;
        this.qtdNotificacao = 0;
        notificacao = new HashSet<String>();
        permissoes = new HashSet<String>();
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

    public int getQtdNotificacao() {
        return qtdNotificacao;
    }

    public Set<String> getNotificacao() {
        return notificacao;
    }

    public Set<String> getPermissoes() {
        return permissoes;
    }

    public void setQtdNotificacao(int qtdNotificacao) {
        this.qtdNotificacao = qtdNotificacao;
    }

    public void setNotificacao(Set<String> notificacao) {
        this.notificacao = notificacao;
    }

    public void setPermissoes(Set<String> permissoes) {
        this.permissoes = permissoes;
    }
    
    
}
