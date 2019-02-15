package br.com.guacom.enterprise.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.guacom.enterprise.dao.DependenteDAO;
import br.com.guacom.enterprise.dao.FuncionarioDAO;
import br.com.guacom.enterprise.model.ConsultorDeVendas;
import br.com.guacom.enterprise.model.Funcionario;
import br.com.guacom.enterprise.view.CadastroView;

public class Controller implements ActionListener {
	private CadastroView cv;
	private FuncionarioDAO fd;
	private DependenteDAO dd;

	public Controller(CadastroView cv, FuncionarioDAO fd, DependenteDAO dd) {
		this.fd = fd;
		this.dd = dd;
		this.cv = cv;
		configureComponents();
		enabled("Navegar");
		loadData();
	}

	private void configureComponents() {
		cv.btnNovo.addActionListener(this);
		cv.btnEditar.addActionListener(this);
		cv.btnCancelar.addActionListener(this);
		cv.btnExcluir.addActionListener(this);
		cv.btnSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cv.btnNovo) {
			enabled("Cadastrar");
		}
		if (e.getSource() == cv.btnCancelar) {
			enabled("Navegar");
			clearDataField();
		}
		if (e.getSource() == cv.btnSalvar) {
			try {
				String nome = cv.txtNome.getText().trim();
				String sexo = String.valueOf(cv.boxSexo.getSelectedItem());
				String nivel = String.valueOf(cv.boxNivel.getSelectedItem());
				boolean isInsert = false;
				try {
					BigDecimal bonusMensal = BigDecimal.valueOf(Double.valueOf(cv.txtBonus.getText().trim()));
					isInsert = fd.insert(new ConsultorDeVendas(nome, nivel, bonusMensal, sexo));
				} catch (NumberFormatException | NullPointerException ex) {
					isInsert = fd.insert(new Funcionario(nome, nivel, sexo));
				}
				enabled("Navegar");
				JOptionPane.showMessageDialog(cv,
						isInsert == true ? String.format("Funcionário %s foi cadastrado com sucesso!", nome)
								: "Erro no cadastro!");
			} catch (IllegalArgumentException | NullPointerException ex) {
				ex.printStackTrace();
			}
			clearDataField();
		}
		if (e.getSource() == cv.btnExcluir) {
			int linha = cv.tblFuncionario.getSelectedRow();
			int id = Integer.parseInt(String.valueOf(cv.tblFuncionario.getValueAt(linha, 0)));
			String nome = String.valueOf(cv.tblFuncionario.getValueAt(linha, 1));
			if(fd.delete(id))
				JOptionPane.showMessageDialog(cv, String.format("Funcionário %s foi deletado", nome));
			else
				JOptionPane.showMessageDialog(cv, String.format("Erro na deleção."));
		}
		loadData();
	}
	
	private void loadData() {
		DefaultTableModel dtm = new DefaultTableModel();
		cv.tblFuncionario.setModel(dtm);
		dtm.addColumn("Código");
		dtm.addColumn("Nome");
		dtm.addColumn("Salário");
		dtm.addColumn("Nível");
		Object[] columns = new Object[4];
		try {
			for (Funcionario f : fd.list()) {
				columns[0] = f.getId();
				columns[1] = f.getNome();
				columns[2] = f.calcularSalario().doubleValue();
				columns[3] = f.getNivel();
				dtm.addRow(columns);
			}
		} catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(cv, "Nenhum funcionário cadastrado!");
		}
	}

	private void clearDataField() {
		cv.txtNome.setText("");
		cv.txtBonus.setText("");
		cv.boxSexo.setSelectedIndex(0);
		cv.boxNivel.setSelectedIndex(0);
	}

	private void enabled(String modo) {
		switch (modo) {
			case "Navegar":
				cv.btnNovo.setEnabled(true);
				cv.btnEditar.setEnabled(true);
				cv.btnExcluir.setEnabled(true);
				cv.btnSalvar.setEnabled(false);
				cv.btnCancelar.setEnabled(false);
				cv.btnConfirmar.setEnabled(false);
				cv.txtNome.setEnabled(false);
				cv.txtBonus.setEnabled(false);
				cv.boxNivel.setEnabled(false);
				cv.boxSexo.setEnabled(false);
				break;
			case "Cadastrar":
				cv.btnNovo.setEnabled(false);
				cv.btnEditar.setEnabled(false);
				cv.btnExcluir.setEnabled(false);
				cv.btnSalvar.setEnabled(true);
				cv.btnCancelar.setEnabled(true);
				cv.btnConfirmar.setEnabled(false);
				cv.txtNome.setEnabled(true);
				cv.txtBonus.setEnabled(true);
				cv.boxNivel.setEnabled(true);
				cv.boxSexo.setEnabled(true);
				break;
			case "Editar":
				cv.btnNovo.setEnabled(false);
				cv.btnEditar.setEnabled(false);
				cv.btnExcluir.setEnabled(false);
				cv.btnSalvar.setEnabled(false);
				cv.btnCancelar.setEnabled(true);
				cv.btnConfirmar.setEnabled(true);
				cv.txtNome.setEnabled(true);
				cv.txtBonus.setEnabled(true);
				cv.boxNivel.setEnabled(true);
				cv.boxSexo.setEnabled(true);
				break;
			case "Excluir":
				cv.btnNovo.setEnabled(false);
				cv.btnEditar.setEnabled(false);
				cv.btnExcluir.setEnabled(false);
				cv.btnSalvar.setEnabled(true);
				cv.btnCancelar.setEnabled(true);
				cv.btnConfirmar.setEnabled(false);
				cv.txtNome.setEnabled(true);
				cv.txtBonus.setEnabled(true);
				cv.boxNivel.setEnabled(true);
				cv.boxSexo.setEnabled(true);
				break;
		}
	}
}