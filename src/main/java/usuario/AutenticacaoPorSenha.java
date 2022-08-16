/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import dao.PessoaDao;

/**
 *
 * @author jhonatan
 */
public class AutenticacaoPorSenha implements IMetodoAutenticacao {

    @Override
    public boolean autentica(Pessoa pessoa) {
        PessoaDao pDao = new PessoaDao();
        Pessoa pessoaBanco = new Pessoa();
        
        if(pDao.eVazio() == 0){
            pDao.create(pessoa);
            System.out.println("Primeiro usuario do sistema");
            return true;
        } else {
            if(pDao.verificaNome(pessoa.getNome()) == 0){
                return false;
            }
            pessoaBanco = pDao.readByName(pessoa.getNome());
               
            return pessoaBanco.getSenha().equals(pessoa.getSenha());
        }
        
    }
      
}
