package br.com.guacom.enterprise.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.guacom.enterprise.dao.DependenteDAO;
import br.com.guacom.enterprise.model.Dependente;
import br.com.guacom.enterprise.model.Funcionario;
import br.com.guacom.enterprise.principal.Principal;
import br.com.guacom.enterprise.view.DependenteView;

public class DependenteController implements ActionListener {
	private DependenteView dv;
	private DependenteDAO dd;
	private CadastroController cc;
	private Funcionario f;
	private boolean isInsert;

	public DependenteController(DependenteView dv, DependenteDAO dd, CadastroController cc) {
		this.dv = dv;
		this.dd = dd;
		this.cc = cc;
		configureComponents(dv);
		enabled("Navegar");
		dv.setVisible(true);
	}

	public DependenteController(DependenteView dv, DependenteDAO dd, Funcionario f, boolean isInsert) {
		this.dv = dv;
		this.dd = dd;
		configureComponents(dv);
		enabled("Navegar");
		Principal.visible(false, true);
		this.f = f;
		this.isInsert = isInsert;
	}

	private void configureComponents(DependenteView dv) {
		dv.btnConcluir.addActionListener(this);
		dv.btnEditar.addActionListener(this);
		dv.btnExcluir.addActionListener(this);
		dv.btnNovo.addActionListener(this);
		dv.btnSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dv.btnNovo) {
			enabled("Cadastrar");
		}

		if (e.getSource() == dv.btnConcluir) {
			JOptionPane.showMessageDialog(dv,
					isInsert == true ? String.format("Funcionário %s foi cadastrado com sucesso!", f.getNome())
							: "Erro no cadastro!");
			Principal.visible(true, false);
		}

		if (e.getSource() == dv.btnSalvar) {
			String nome;
			try {
				nome = dv.txtNome.getText().trim();
				dd.insert(new Dependente(nome, f));
			} catch (Exception ex) {
				if (ex instanceof IllegalArgumentException)
					JOptionPane.showMessageDialog(dv, String.format("Erro: %s", ex.getMessage()));
				else
					JOptionPane.showMessageDialog(dv, "Erro: " + ex.getMessage());
			}
			enabled("Navegar");
		}

		if (e.getSource() == dv.btnExcluir) {
			int linha = dv.tblDependente.getSelectedRow();
			try {
				String nome = dv.tblDependente.getValueAt(linha, 1).toString();
				boolean isDelete = false;
				if (linha >= 0) {
					int id = Integer.parseInt(dv.tblDependente.getValueAt(linha, 0).toString());
					isDelete = dd.delete(id);
				}
				JOptionPane.showMessageDialog(dv,
						String.format((isDelete == true ? "Dependente %s foi deletado com sucesso!"
								: "Dependente %s não foi deletado"), nome));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(dv, String.format("Erro: %s", ex.getMessage()));
			}
		}
		clearDataFields();
		list();
	}

	private void clearDataFields() {
		dv.txtCodigo.setText("");
		dv.txtNome.setText("");
	}

	private void enabled(String modo) {
		switch (modo) {
		case "Navegar":
			dv.btnNovo.setEnabled(true);
			dv.btnEditar.setEnabled(true);
			dv.btnExcluir.setEnabled(true);
			dv.btnConcluir.setEnabled(true);
			dv.btnConfirmar.setEnabled(false);
			dv.btnSalvar.setEnabled(false);
			dv.txtNome.setEnabled(false);
			dv.txtCodigo.setEnabled(false);

			break;
		case "Cadastrar":
			dv.btnNovo.setEnabled(false);
			dv.btnEditar.setEnabled(false);
			dv.btnExcluir.setEnabled(false);
			dv.btnSalvar.setEnabled(true);
			dv.btnConfirmar.setEnabled(false);
			dv.btnConcluir.setEnabled(false);
			dv.txtNome.setEnabled(true);
			dv.txtCodigo.setEnabled(false);
			break;
		case "Editar":
			dv.btnNovo.setEnabled(false);
			dv.btnEditar.setEnabled(false);
			dv.btnExcluir.setEnabled(false);
			dv.btnSalvar.setEnabled(false);
			dv.btnConfirmar.setEnabled(true);
			dv.btnConcluir.setEnabled(false);
			dv.txtNome.setEnabled(true);
			dv.txtCodigo.setEnabled(true);
			break;
		case "Excluir":
			dv.btnNovo.setEnabled(false);
			dv.btnEditar.setEnabled(false);
			dv.btnExcluir.setEnabled(false);
			dv.btnSalvar.setEnabled(true);
			dv.btnConcluir.setEnabled(false);
			dv.txtNome.setEnabled(true);
			dv.txtCodigo.setEnabled(false);
			break;
		}
	}

	private void list() {
		DefaultTableModel dtm = new DefaultTableModel();
		dv.tblDependente.setModel(dtm);
		dtm.addColumn("Código");
		dtm.addColumn("Nome Dependente");
		dtm.addColumn("Nome Funcionário");
		Object[] columns = new Object[3];
		for (Funcionario f : Principal.fd.list()) {
			try {
				for (Dependente d : f.getDependentes()) {
					columns[0] = d.getIdDependente();
					columns[1] = d.getNome();
					columns[2] = d.getFuncionario().getNome();
					dtm.addRow(columns);
				}
			} catch(NullPointerException e) {
				continue;
			}
		}
	}
}