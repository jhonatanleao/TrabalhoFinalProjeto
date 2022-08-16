/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import com.pss.imagem.processamento.decorator.ImagemComponente;
import java.util.ArrayList;

/**
 *
 * @author jhonatan
 */
// codigo base no link https://brizeno.wordpress.com/category/padroes-de-projeto/memento/
public class Zelador {
	protected ArrayList<ImagemMemento> estados;
	
	public Zelador(){
		estados = new ArrayList<ImagemMemento>();
	}

	public void add(ImagemMemento imagem){
		estados.add(imagem);
	}

	public ImagemComponente getUltimoEstadoSalvo(){
		if(estados.size() <= 0) {
			return null;
		}
		ImagemMemento ultimo = estados.get(estados.size() -1);
		estados.remove(estados.size() - 1);
		return ultimo.getImagemMemento();
	}

	public ImagemComponente resetaZelador(){
		ImagemMemento primeiro = estados.get(0);
		this.estados = new ArrayList<ImagemMemento>();
		return primeiro.getImagemMemento();
	}
    
}
