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
import view.TelaPrincipalView;

/**
 *
 * @author jhonatan
 */
public class TelaPrincipalPresenter {
    TelaPrincipalView view;
    
    public TelaPrincipalPresenter(){
        view = new TelaPrincipalView();
        
        this.view.getBtnAbrir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                abrir();
            }
        });
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void abrir(){
        JFileChooser fileChooser = view.getFileChooser();
        fileChooser.setDialogTitle("Procurar Imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("imagem", "jpg", "png");
        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(view);
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            //fazer a verificação se pode abrir
            new TelaImagemPresenter(file);
            
        }
    }
}
