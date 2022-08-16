/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import pessoa.Pessoa;

/**
 *
 * @author jhonatan
 */
public abstract class UsuarioFactory {
    
    public abstract Pessoa criar(String nome, String senha);
}
