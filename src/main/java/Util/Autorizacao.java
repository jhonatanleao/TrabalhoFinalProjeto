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
public interface Autorizacao {
    
    public boolean autoriza(Set<String> autorizacoes, String caminhoImagem);
}
