/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import dao.PessoaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pessoa.Pessoa;
import view.TelaCadastroView;

/**
 *
 * @author jhonatan
 */
public class TelaCadastroPresenter {
    TelaCadastroView view;
    
    public TelaCadastroPresenter(){
        view = new TelaCadastroView();
        
        
        this.view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                salvar();
            }
        });
        
        this.view.getBtnCancelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cancelar();
            }
        });
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    
    }
    
    public void salvar(){
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        int flag = 0;
        
        if(!usuario.isEmpty() && !senha.isEmpty()){
            Pessoa pessoa = new Pessoa(usuario, senha);
            PessoaDao pDao = new PessoaDao();
            flag = pDao.create(pessoa);
            if(flag == 1){
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Usuario já utilizado, tente outro!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Não é permitido campos em branco", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cancelar(){
        view.dispose();
    }
}
