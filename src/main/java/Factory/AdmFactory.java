/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import java.util.HashSet;
import java.util.Set;
import pessoa.Pessoa;

/**
 *
 * @author jhonatan
 */
public class AdmFactory extends UsuarioFactory{

    @Override
    public Pessoa criar(String nome, String senha) {
        Pessoa pessoa = new Pessoa(nome, senha);
        Set<String> permissoes = new HashSet<String>();
        permissoes.add("adm");
        pessoa.setPermissoes(permissoes);
        return pessoa;
    }
    
}
