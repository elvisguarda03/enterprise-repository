package br.com.guacom.enterprise.principal;

import javax.swing.UnsupportedLookAndFeelException;

import br.com.guacom.enterprise.controller.Controller;
import br.com.guacom.enterprise.dao.DependenteDAO;
import br.com.guacom.enterprise.dao.FuncionarioDAO;
import br.com.guacom.enterprise.view.CadastroView;

public class Principal {
	
	public static void main(String[] args) {
		CadastroView cv = new CadastroView();
		try {
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				cv.setVisible(true);
			}
		});
		FuncionarioDAO fd = new FuncionarioDAO();
		DependenteDAO dd = new DependenteDAO();
		Controller c = new Controller(cv, fd, dd);
	}
}
