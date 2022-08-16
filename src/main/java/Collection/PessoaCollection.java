/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.ArrayList;
import pessoa.Pessoa;

/**
 *
 * @author jhonatan
 */
public class PessoaCollection {
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    public void add(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    
    public Pessoa buscaByName(String nome){
        for(Pessoa pessoa : pessoas){
            if(pessoa.getNome().equals(nome))
                return pessoa;
        }
        return null;
    }
}
