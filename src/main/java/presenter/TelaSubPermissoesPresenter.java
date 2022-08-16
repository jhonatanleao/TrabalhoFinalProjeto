/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import dao.ImagemDao;
import java.io.File;
import javax.swing.JComboBox;
import proxy.ImagemProxy;
import view.TelaSubPermissoesView;

/**
 *
 * @author jhonatan
 */
public class TelaSubPermissoesPresenter {
    TelaSubPermissoesView view;
    
    public TelaSubPermissoesPresenter(){
        view = new TelaSubPermissoesView();
        preencheCombo();
        
        //getSelectedItem();
        //add no set da pessoa que eu selecionei antes
        
        
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void preencheCombo(){
        JComboBox combo = view.getCbxLista();
        combo.removeAllItems();
        ImagemDao imgDao = new ImagemDao();
        combo.addItem("Toda a pasta");
        File file = new File("src/imagens");
	File afile[] = file.listFiles();
	int i = 0;
	for (int j = afile.length; i < j; i++) {
		File arquivos = afile[i];
                combo.addItem(arquivos.getName());		
	}
        
    }
}
