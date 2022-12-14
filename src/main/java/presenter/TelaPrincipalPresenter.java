/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import dao.ImagemDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pessoa.Pessoa;
import proxy.ImagemProxy;
import view.TelaPrincipalView;

/**
 *
 * @author jhonatan
 */
public class TelaPrincipalPresenter {
    TelaPrincipalView view;
    
    public TelaPrincipalPresenter(Pessoa pessoa){
        view = new TelaPrincipalView();
        
        if(pessoa.getAdm() == 0){
            view.getBtnListar().setVisible(false);
            view.getBtnAdc().setVisible(false);
            view.getLblPerfil().setText("Usuario");
        } else {
            view.getLblPerfil().setText("Administrador");
        }
        view.getLblUsuario().setText(pessoa.getNome());
        
        this.view.getBtnAbrir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    abrir(pessoa);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaPrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getBtnAdc().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                adc();
            }
        });    
        
        this.view.getBtnListar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                permissao();
            }
        });  
        
        this.view.getBtnExcluir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                excluir(pessoa);
            }
        }); 
        
        this.view.getBtnSair().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                view.dispose();
            }
        }); 
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void abrir(Pessoa pessoa) throws IOException, InterruptedException{
        JFileChooser fileChooser = view.getFileChooser();
        File file = new File("src/imagens");
        fileChooser.setCurrentDirectory(file);
        fileChooser.setDialogTitle("Procurar Imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("imagem", "jpg", "png");
        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(view);
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            System.out.println(file.getName());
            List<ImagemProxy> listImagem = new ArrayList();
            ImagemDao imgDao = new ImagemDao();
            listImagem = imgDao.read();
            boolean flag= false;

            for(ImagemProxy imagem : listImagem){
                flag = imagem.abre(pessoa.getPermissoes(), file.getName());
            }
            
            if(flag == true){
                new TelaImagemPresenter(file);
            } else {
                JOptionPane.showMessageDialog(view, "Voc?? n??o tem permiss??o para visualizar essa imagem", "Erro", JOptionPane.ERROR_MESSAGE);
            }          
        }
    }
    
    public void adc(){
        new TelaCadastroPresenter();
    }
    
    public void permissao(){
        new TelaPermissoesPresenter();
    }
    
    public void excluir(Pessoa pessoa){
        JFileChooser fileChooser = view.getFileChooser();
        File file = new File("src/imagens");
        fileChooser.setCurrentDirectory(file);
        fileChooser.setDialogTitle("Procurar Imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("imagem", "jpg", "png");
        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(view);
        
        boolean flag= false;
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            List<ImagemProxy> listImagem = new ArrayList();
            ImagemDao imgDao = new ImagemDao();
            listImagem = imgDao.read();
            for(ImagemProxy imagem : listImagem){
                flag = imagem.excluir(pessoa.getPermissoes(), file.getName());
            }
            
            if(flag == true){
                file.delete();
                JOptionPane.showMessageDialog(view, "Foto excluida com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view, "Voc?? n??o tem permiss??o para excluir essa imagem", "Erro", JOptionPane.ERROR_MESSAGE);
            }  
            
        }      
    }
}
