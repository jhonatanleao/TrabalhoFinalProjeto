/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pss.trabalhofinal;

import dao.NotificacaoDao;
import dao.PessoaDao;
import model.Notificacao;
import model.Pessoa;

/**
 *
 * @author jhonatan
 */
public class TrabalhoFinal {

    public static void main(String[] args) {
        //Pessoa pessao = new Pessoa("Joao gordola", "123", 1);
        //PessoaDao pDao = new PessoaDao();
        //pDao.create(pessao);
        
        Notificacao not = new Notificacao(1, "testando");
        NotificacaoDao nDao = new NotificacaoDao();
        nDao.create(not);
    }
}
