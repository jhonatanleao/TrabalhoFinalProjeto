/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import Util.ImagemMemento;
import Util.Zelador;
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
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jhonatan
 */
public class TelaImagemPresenter {
    private TelaImagemView view;
    private ImagemComponente imagem;
    private File file;
    private Zelador zelador = new Zelador();
    
    
    public TelaImagemPresenter(File file) throws IOException, InterruptedException{
        this.file = file;
        view = new TelaImagemView();
        imagem = new Imagem(file.getPath());
        

        this.view.getLblImagem().setIcon(new ImageIcon(file.getPath()));
        
        this.view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fechar();
            }
        });

        this.view.getBtnDesfazer().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    desfazer();
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getBtnRestaurar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    restaurar();
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkAzul().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    azul();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        this.view.getChkCinza().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    cinza();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkEspelhada().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    espelhada();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkNegativa().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    negativa();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkPixelar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    pixelar();
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkRotacionar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    rotacionar();
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkSépia().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    sepia();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkVerde().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    verde();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getChkVermelho().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    vermelho();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TelaImagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        
    }

    
    public void salvar() throws IOException{
        var caminhoPNG = file.getPath().replace(".jpg", ".png");
        var imagePNG = new File(caminhoPNG);
        ImageIO.write(imagem.getImagem(), "png", imagePNG);
        BufferedImage image = ImageIO.read(imagePNG);
        
        BufferedImage result = new BufferedImage(
            image.getWidth(),
            image.getHeight(),
            BufferedImage.TYPE_INT_RGB);

        result.createGraphics().drawImage(image, 0, 0, Color.white, null);
        
        ImageIO.write(result, "jpg", file.getCanonicalFile());
    }
    
    public void desfazer() throws IOException{
	  ImagemComponente imagemDesfeita = zelador.getUltimoEstadoSalvo();
	  if(imagemDesfeita != null){
	  	this.imagem = imagemDesfeita;
	  }
        view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
    }
    
    public void restaurar() throws IOException{
        this.imagem = zelador.resetaZelador();
	  view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));
	  salvarImagem(); 
    }
    
    public void fechar(){
        view.dispose();
    }
    
    // codigo baseado na segunda soluçao do link https://stackoverflow.com/questions/2290336/converting-png-into-jpeg
    public void salvarImagem() throws IOException{
        var caminhoNewImage = file.getPath().replace(".jpg", ".png");
        var PNGImage = new File(caminhoNewImage);
        ImageIO.write(imagem.getImagem(), "png", PNGImage);
        BufferedImage image = ImageIO.read(PNGImage);
        
        BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);

        newImage.createGraphics().drawImage(image, 0, 0, Color.black, null);
        
        ImageIO.write(newImage, "jpg", file.getCanonicalFile());  
        PNGImage.delete();
    }
    
    public void cinza() throws InterruptedException, IOException{
	  zelador.add(new ImagemMemento(imagem));
        imagem = new TomDeCinzaDecorator(imagem);
	  salvarImagem(); 
    }

    public void espelhada() throws InterruptedException, IOException{
	  zelador.add(new ImagemMemento(imagem));
        imagem = new EspelhadaDecorator(imagem);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem())); 
    }

    public void negativa() throws InterruptedException, IOException{
	  zelador.add(new ImagemMemento(imagem));
        imagem = new NegativaDecorator(imagem);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));     
    }

    public void pixelar() throws IOException{
	  zelador.add(new ImagemMemento(imagem));
		//criar um inteiro para esse res
        //imagem = new PixeladaDecorator(imagem, res);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));         
    }

    public void rotacionar() throws IOException{
	  zelador.add(new ImagemMemento(imagem));
		//criar um inteiro para esse res
        //imagem = new RotacionaDecorator(imagem, res);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));         
    }

    public void sepia() throws InterruptedException, IOException{
	zelador.add(new ImagemMemento(imagem));
        imagem = new SepiaDecorator(imagem);
        salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));         
    }

    public void verde() throws InterruptedException, IOException{
	  zelador.add(new ImagemMemento(imagem));
        imagem = new VerdeDecorator(imagem);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));           
    }

    public void vermelho() throws InterruptedException, IOException{
	  zelador.add(new ImagemMemento(imagem));
        imagem = new VermelhoDecorator(imagem);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));        
    }

    public void brilho() throws IOException{
	  zelador.add(new ImagemMemento(imagem));
		//criar um inteiro para esse res
        //imagem = new BrilhoDecorator(imagem, 1);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));   
    }

    public void azul() throws InterruptedException, IOException{
	  zelador.add(new ImagemMemento(imagem));
        imagem = new AzulDecorator(imagem);
	  salvarImagem(); 
        this.view.getLblImagem().setIcon(new ImageIcon(imagem.getImagem()));           
    }
}


