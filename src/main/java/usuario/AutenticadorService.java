/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

/**
 *
 * @author jhonatan
 */
public class AutenticadorService {
    
    IMetodoAutenticacao metodo;
    
    public AutenticadorService(){
        metodo = new AutenticacaoPorSenha();
    }
    
    public boolean processa(Pessoa pessoa){
        return metodo.autentica(pessoa);
    }
    
}
