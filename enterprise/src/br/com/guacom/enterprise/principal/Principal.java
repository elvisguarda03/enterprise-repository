package br.com.guacom.enterprise.principal;

import java.awt.event.ActionEvent;

import javax.swing.UnsupportedLookAndFeelException;

import br.com.guacom.enterprise.controller.CadastroController;
import br.com.guacom.enterprise.controller.DependenteController;
import br.com.guacom.enterprise.dao.DependenteDAO;
import br.com.guacom.enterprise.dao.FuncionarioDAO;
import br.com.guacom.enterprise.model.Funcionario;
import br.com.guacom.enterprise.view.CadastroView;
import br.com.guacom.enterprise.view.DependenteView;

public class Principal {
	public static CadastroView cv;
	public static DependenteView dv;
	public static FuncionarioDAO fd;
	public static DependenteDAO dd;
	public static void main(String[] args) {
		cv = new CadastroView();
		dv = new DependenteView();
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
		dd = new DependenteDAO();
		fd = new FuncionarioDAO(dd);
		CadastroController c = new CadastroController(cv, fd, dd);
	}
	
	public static void visible(boolean isVisibleC, boolean isVisibleD) {
		cv.setVisible(isVisibleC);
		dv.setVisible(isVisibleD);
		if(!isVisibleC)
			cv.dispose();
		else
			dv.dispose();
	}

	public static void novoDependente(Funcionario f, boolean isInsert, DependenteDAO dd) {
		DependenteController dc = new DependenteController(dv, dd, f, isInsert);
	}
	
	public static void delete(Funcionario f) {
		dd.delete(f.getIdFuncionario());
	}
}