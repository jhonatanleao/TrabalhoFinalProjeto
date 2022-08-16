/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.util.Set;

/**
 *
 * @author jhonatan
 */
public class GerenciadorAutorizacao {
    private Autorizacao autorizacao;

    public GerenciadorAutorizacao(Autorizacao autorizacao) {
        this.autorizacao = autorizacao;
    }
    
    public boolean autoriza(Set<String> autorizacoes, String caminhoImagem){
        return autorizacao.autoriza(autorizacoes, caminhoImagem);
    }
    
}
