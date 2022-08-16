/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import dao.ImagemDao;
import dao.PessoaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import pessoa.Pessoa;
import proxy.ImagemProxy;
import view.TelaSubPermissoesView;

/**
 *
 * @author jhonatan
 */
public class TelaSubPermissoesPresenter {
    TelaSubPermissoesView view;
    
    public TelaSubPermissoesPresenter(Pessoa pessoa){
        view = new TelaSubPermissoesView();
        preencheCombo();
        
        view.getTxtNome().setText(pessoa.getNome());
        view.getTxtNome().setEditable(false);
            //getSelectedItem();
            //add no set da pessoa que eu selecionei antes
            
        this.view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                salvar(pessoa);
            }
        });
        
        this.view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fechar();
            }
        });
            //falta da um update no banco com base nessa pessoa aqui

        
        
        
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
    
    public void salvar(Pessoa pessoa){
        String selecionado = view.getCbxLista().getSelectedItem().toString();
        if(selecionado.equals("Toda a pasta"))
              selecionado = "tudo";
        System.out.println(selecionado);
        Set<String> permissoes = new HashSet<String>();
        permissoes = pessoa.getPermissoes();
        permissoes.add(selecionado);
        pessoa.setPermissoes(permissoes);
        PessoaDao pDao = new PessoaDao();
        pDao.update(pessoa);
    }
    
    public void fechar(){
        view.dispose();
        new TelaPermissoesPresenter();
    }
}
