package br.com.guacom.enterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DependenteView extends JFrame {

	private JPanel contentPane;
	public JTable tblDependente;
	public JTextField txtNome;
	public JTextField txtCodigo;
	public JButton btnSalvar;
	public JButton btnExcluir;
	public JToggleButton btnEditar;
	public JButton btnConcluir;
	public JButton btnNovo;
	public JButton btnConfirmar;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public DependenteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dependente", null, panel, null);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnConcluir = new JButton("Concluir");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnEditar = new JToggleButton("Editar");
		
		btnExcluir = new JButton("Excluir");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Dependente",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(16)
									.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConcluir, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(22)))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addGap(125))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConcluir)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnNovo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setDocument(new OnlyString());
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setDocument(new OnlyNumber());
		
		btnSalvar = new JButton("Salvar");
		
		btnConfirmar = new JButton("Confirmar");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnConfirmar)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(83))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome)
						.addComponent(lblNewLabel))
					.addGap(15)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnConfirmar)))
		);
		panel_1.setLayout(gl_panel_1);
		
		tblDependente = new JTable();
		tblDependente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome Dependente", "Nome Funcion\u00E1rio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblDependente.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblDependente.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(tblDependente);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}
}