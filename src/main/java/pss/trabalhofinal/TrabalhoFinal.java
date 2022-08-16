/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pss.trabalhofinal;

import Util.ProcessaString;
import dao.PessoaDao;
import java.util.HashSet;
import java.util.Set;
import model.Notificacao;
import presenter.TelaLoginPresenter;
import presenter.TelaImagemPresenter;
import usuario.Pessoa;

/**
 *
 * @author jhonatan
 */
public class TrabalhoFinal {

    public static void main(String[] args) {
        //Pessoa pessao = new Pessoa("Joao gordola", "123", 1);
        //PessoaDao pDao = new PessoaDao();
        //pDao.create(pessao);
        
        //Notificacao not = new Notificacao(1, "testando");
        //PessoaDao nDao = new PessoaDao();
        //nDao.read();
        //new TelaImagemPresenter();
        new TelaLoginPresenter();
        
//        teste dos set ir pro banco e voltar
//        Set<String> listString = new HashSet<String>();
//        Pessoa pessoa = new Pessoa("jose", "123");
//        pessoa.getNotificacao().add("teste1");
//        pessoa.getNotificacao().add("teste2");
//        pessoa.getNotificacao().add("teste3");
//        
//        ProcessaString prossamento = new ProcessaString();
//        String teste = prossamento.compila(pessoa.getNotificacao());
//        System.out.println(teste);
//        listString = prossamento.descompila(teste);
//        for(String frase : listString){
//            System.out.println(frase);
//        }
    }
}
