package br.com.guacom.enterprise.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroView extends JFrame {
	private JScrollPane scrollPane;
	public JTable tblFuncionario;
	public JTextField txtNome;
	public JTextField txtBonus;
	public JButton btnNovo;
	public JButton btnEditar;
	public JButton btnExcluir;
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JButton btnConfirmar;
	public JComboBox boxSexo;
	public JComboBox boxNivel;
	public JTextField txtCodigo;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public CadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 425);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE));

		JPanel c_table = new JPanel();
		tabbedPane.addTab("Funcion\u00E1rios", null, c_table, null);

		JScrollPane scrollPane_1 = new JScrollPane();

		JPanel c_campos = new JPanel();
		c_campos.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Funcion\u00E1rio",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

		btnNovo = new JButton("Novo");

		btnEditar = new JButton("Editar");

		btnExcluir = new JButton("Excluir");
		GroupLayout gl_c_table = new GroupLayout(c_table);
		gl_c_table.setHorizontalGroup(gl_c_table.createParallelGroup(Alignment.TRAILING).addGroup(gl_c_table
				.createSequentialGroup().addGap(28)
				.addGroup(gl_c_table.createParallelGroup(Alignment.TRAILING)
						.addComponent(c_campos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_c_table.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
				.addGap(20)));
		gl_c_table.setVerticalGroup(gl_c_table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_c_table.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_c_table.createParallelGroup(Alignment.BASELINE).addComponent(btnNovo)
								.addComponent(btnExcluir).addComponent(btnEditar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(c_campos, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(19, Short.MAX_VALUE)));

		JLabel lblNome = new JLabel("Nome:");

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setDocument(new OnlyString());

		JLabel lblSalario = new JLabel("B\u00F4nus:");

		txtBonus = new JTextField();
		txtBonus.setColumns(10);
		txtBonus.setDocument(new OnlyNumber());

		boxSexo = new JComboBox();
		boxSexo.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione uma op\u00E7\u00E3o", "Masculino", "Feminino" }));

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));

		boxNivel = new JComboBox();
		boxNivel.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione uma op\u00E7\u00E3o", "Trainee", "Pleno", "S\u00EAnior" }));

		JLabel lblNewLabel = new JLabel("N\u00EDvel Profissional:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnSalvar = new JButton("Salvar");

		btnCancelar = new JButton("Cancelar");
		
		btnConfirmar = new JButton("Confirmar");
		
		lblNewLabel_1 = new JLabel("C\u00F3digo:");
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		GroupLayout gl_c_campos = new GroupLayout(c_campos);
		gl_c_campos.setHorizontalGroup(
			gl_c_campos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_c_campos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_c_campos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_c_campos.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(53)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_c_campos.createSequentialGroup()
							.addComponent(lblSalario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtBonus, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addGap(53)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(boxSexo, 0, 90, Short.MAX_VALUE))
						.addGroup(gl_c_campos.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boxNivel, 0, 87, Short.MAX_VALUE))
						.addGroup(gl_c_campos.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_c_campos.setVerticalGroup(
			gl_c_campos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_c_campos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_c_campos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_c_campos.createParallelGroup(Alignment.BASELINE)
						.addComponent(boxNivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(txtNome))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_c_campos.createParallelGroup(Alignment.BASELINE)
						.addComponent(boxSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblSalario)
						.addComponent(txtBonus, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_c_campos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar)
						.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(5))
		);
		c_campos.setLayout(gl_c_campos);

		tblFuncionario = new JTable();
		scrollPane_1.setViewportView(tblFuncionario);
		tblFuncionario.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		tblFuncionario.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"C\u00F3digo", "Nome", "Sal\u00E1rio", "N\u00EDvel"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Double.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		tblFuncionario.setFillsViewportHeight(true);
		c_table.setLayout(gl_c_table);

		scrollPane = new JScrollPane();
		getContentPane().setLayout(groupLayout);
	}
}