/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import dao.ImagemDao;
import dao.PessoaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pessoa.Pessoa;
import view.TelaPermissoesView;


/**
 *
 * @author jhonatan
 */
public class TelaPermissoesPresenter {
    TelaPermissoesView view;
    
    public TelaPermissoesPresenter(){
        view = new TelaPermissoesView();
        readJTable();
        
        this.view.getBtnPermissao().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                permissao();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void readJTable(){
        JTable tblView = view.getTblTabela();
        DefaultTableModel model = (DefaultTableModel) tblView.getModel();
        model.setNumRows(0);
        PessoaDao pDao = new PessoaDao();
        
        if(!pDao.read().isEmpty()){
            for(Pessoa pessoa : pDao.read()){
                model.addRow(new Object[]{
                    pessoa.getNome(),
                    pessoa.getPermissoes()
                });
            }
        }
        
    }
    
    public void permissao(){
        new TelaSubPermissoesPresenter();
    }
    
    public void excluir(){
        
    }
    
    public void fechar(){
        
    }
}
