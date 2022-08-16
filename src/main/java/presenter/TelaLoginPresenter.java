/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import Factory.AdmFactory;
import dao.PessoaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pessoa.AutenticadorService;
import pessoa.Pessoa;
import view.TelaLoginView;


/**
 *
 * @author jhonatan
 */
public class TelaLoginPresenter {
    private TelaLoginView view;
    
    public TelaLoginPresenter(){
        view = new TelaLoginView();
        
    this.view.getBtnEntrar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                entrar();
            }
        });
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void entrar(){
        String usuario = this.view.getTxtUsuario().getText();
        String senha = this.view.getTxtSenha().getText();
        Pessoa pessoa = new Pessoa(usuario, senha);
        PessoaDao pDao = new PessoaDao();
        
        if(pDao.eVazio() == 0){
            AdmFactory admFactory = new AdmFactory();
            pessoa = admFactory.criar(pessoa.getNome(), pessoa.getSenha());
            pDao.create(pessoa);
            //criar um option pane para falar que foi criado o perfil como adm
            new TelaPrincipalPresenter(pessoa);
        }else {
            AutenticadorService autenticador = new AutenticadorService();
            boolean resultado = autenticador.processa(pessoa);
            if(resultado == true){
                pessoa = pDao.readByName(pessoa.getNome());
                new TelaPrincipalPresenter(pessoa);
            } else {
                JOptionPane.showMessageDialog(view, "Usuario ou senha incorreto", "Erro", JOptionPane.ERROR_MESSAGE);
            }            
        }
        

        
    }
}
