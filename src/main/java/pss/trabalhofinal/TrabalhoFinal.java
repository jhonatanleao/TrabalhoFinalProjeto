/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pss.trabalhofinal;


import dao.ImagemDao;
import java.io.File;
import presenter.TelaLoginPresenter;


/**
 *
 * @author jhonatan
 */
public class TrabalhoFinal {

    public static void main(String[] args) {

        ImagemDao imgDao = new ImagemDao();
        File file = new File("src/imagens");
	File afile[] = file.listFiles();
	int i = 0;
	for (int j = afile.length; i < j; i++) {
		File arquivos = afile[i];
                imgDao.create(arquivos.getName());
	}
        
        new TelaLoginPresenter();
        


    }
}
