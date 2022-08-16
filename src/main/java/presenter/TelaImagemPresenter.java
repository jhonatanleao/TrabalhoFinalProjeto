/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.TelaImagemView;

/**
 *
 * @author jhonatan
 */
public class TelaImagemPresenter {
    private TelaImagemView view;
    
    public TelaImagemPresenter(File file){
        view = new TelaImagemView();
        this.view.getLblImagem().setIcon(new ImageIcon(file.getPath()));
        
        this.view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fechar();
            }
        });
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        
    }
    
    public void salvar(){
        
    }
    
    public void desfazer(){
        
    }
    
    public void restaurar(){
        
    }
    
    public void fechar(){
        view.dispose();
    }
}
