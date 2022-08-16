/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import com.pss.imagem.processamento.decorator.ImagemComponente;

/**
 *
 * @author jhonatan
 */
// codigo base no link https://brizeno.wordpress.com/category/padroes-de-projeto/memento/
public class ImagemMemento {
	protected ImagemComponente imagem;

	public ImagemMemento(ImagemComponente imagem){
		this.imagem = imagem;
	}

	public ImagemComponente getImagemMemento(){
		return this.imagem;
	}
    
}
