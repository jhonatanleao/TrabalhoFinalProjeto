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

import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.BrilhoDecorator;
import com.pss.imagem.processamento.decorator.EspelhadaDecorator;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.NegativaDecorator;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import com.pss.imagem.processamento.decorator.RotacionaDecorator;
import com.pss.imagem.processamento.decorator.SepiaDecorator;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;
import com.pss.imagem.processamento.decorator.VerdeDecorator;
import com.pss.imagem.processamento.decorator.VermelhoDecorator;
import com.pss.imagem.processamento.decorator.Imagem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jhonatan
 */
public class TelaImagemPresenter {
    private TelaImagemView view;
    private ImagemComponente imagem;
    
    
    public TelaImagemPresenter(File file) throws IOException, InterruptedException{
        view = new TelaImagemView();
        imagem = new Imagem(file.getPath());
        imagem = new NegativaDecorator(imagem);
        
        
        
        
        var caminhoPNG = file.getPath().replace(".jpg", ".png");
        FileInputStream inputStream = new FileInputStream(caminhoPNG);
        ImageIO.write(imagem.getImagem(), "png", imagePNG);
        
//        ImageIO.write(imagem.getImagem(), "png", imagePNG);
//        
//        BufferedImage image = ImageIO.read(imagePNG);
//        BufferedImage result = new BufferedImage(
//            image.getWidth(),
//            image.getHeight(),
//            BufferedImage.TYPE_INT_RGB);
//
//        result.createGraphics().drawImage(image, 0, 0, Color.white, null);
        
        ImageIO.write(result, "jpg", file.getCanonicalFile());

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
    
    public void salvarImagem(){
        
    }
    
    public void azul(){
        
    }
}
