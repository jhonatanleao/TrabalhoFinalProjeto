/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

import Util.AutorizacaoPadrao;
import Util.GerenciadorAutorizacao;
import java.util.Set;

/**
 *
 * @author jhonatan
 */
public class ImagemProxy implements ImagemInterface{
    private Imagem imagem;
    private GerenciadorAutorizacao gerenciador = new GerenciadorAutorizacao(new AutorizacaoPadrao());

    public ImagemProxy(int id, String caminho, GerenciadorAutorizacao gerenciador) {
        this.imagem = new Imagem(id, caminho);
        this.gerenciador = gerenciador;
    }

    public ImagemProxy(int id, String caminho) {
        this.imagem = new Imagem(id, caminho);
    }
       
    @Override
    public boolean abre(Set<String> autorizacoes, String caminhoImagem) {
        return gerenciador.autoriza(autorizacoes, caminhoImagem);
    }

    @Override
    public boolean excluir(Set<String> autorizacoes, String caminhoImagem) {
        return gerenciador.autoriza(autorizacoes, caminhoImagem);
    }
    
}
