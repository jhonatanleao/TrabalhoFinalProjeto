/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.ArrayList;
import proxy.ImagemProxy;

/**
 *
 * @author jhonatan
 */
public class ImagemCollection {
    ArrayList<ImagemProxy> imagens = new ArrayList<>();
    
    public void add(ImagemProxy imagem){
        this.imagens.add(imagem);
    }

    public ArrayList<ImagemProxy> getImagem() {
        return imagens;
    }

    
}
