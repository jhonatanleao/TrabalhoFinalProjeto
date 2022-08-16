/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proxy;

import java.util.Set;

/**
 *
 * @author jhonatan
 */
public interface ImagemInterface {
    
    public boolean abre(Set<String> autorizacoes, String caminhoImagem);
    public boolean excluir(Set<String> autorizacoes, String caminhoImagem);
}
