/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

import java.util.Set;

/**
 *
 * @author jhonatan
 */
class Imagem implements ImagemInterface{
    int id;
    private String caminho;

    Imagem(int id, String caminho) {
        this.id = id;
        this.caminho = caminho;
    }

    public Imagem() {
    }

    
    
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean abre(Set<String> autorizacoes, String caminhoImagem) {
        return true;
    }

    @Override
    public boolean excluir(Set<String> autorizacoes, String caminhoImagem) {
        return true;
    }


    
    
}
