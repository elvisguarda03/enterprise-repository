package br.com.guacom.enterprise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.guacom.enterprise.model.ConnectionFactory;
import br.com.guacom.enterprise.model.ConsultorDeVendas;
import br.com.guacom.enterprise.model.Funcionario;

public class FuncionarioDAO {
	private DependenteDAO dDAO;

	public FuncionarioDAO(DependenteDAO dDAO) {
		if(dDAO == null)
			throw new IllegalArgumentException();
		this.dDAO = dDAO;
	}
	
	public boolean insert(Funcionario f) {
		try (Connection con = ConnectionFactory.getConnection()) {
			return execute(f, con);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return false;
	}

	private boolean execute(Funcionario f, Connection con) throws SQLException {
		final String SQL = "insert into funcionario (nome, sexo, nivel, tipo_funcionario) values (?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSexo());
			stmt.setString(3, f.getNivel());
			stmt.setString(4, f.tipoFuncionario());
			stmt.executeUpdate();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = 0;
					id = Integer.parseInt(rs.getString("GENERATED_KEY"));
					if (id > 0) {
						f.setId(id);
						return true;
					}
				}
			} catch (NullPointerException e) {
				return true;
			}
		}
		return false;
	}

	public boolean insert(ConsultorDeVendas cdv) {
		final String SQL = "insert into consultor (valorBonusMensal, id_funcionario) values (?,?)";
		try (Connection con = ConnectionFactory.getConnection()) {
			boolean isExecute = execute(cdv, con);
			if (isExecute) {
				try (PreparedStatement stmt = con.prepareStatement(SQL)) {
					stmt.setBigDecimal(1, cdv.getValorBonusMensal());
					stmt.setInt(2, cdv.getCodFuncionario());
					stmt.executeUpdate();
					return stmt.getUpdateCount() > 0;
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return false;
	}

	public List<Funcionario> list() {
		final String SQL = "select f.*, c.* from funcionario f left outer join consultor c on c.id_funcionario = f.id;";
		List<Funcionario> funcionarios = new ArrayList<>();
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(SQL);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				try {
					if (rs.getString("tipo_funcionario").compareToIgnoreCase("Normal") == 0) {
						Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("nivel"), rs.getString("nome"),
								rs.getString("sexo"));
						funcionarios.add(f);
						f.setDependentes(dDAO.search(f));
					} else {
						ConsultorDeVendas cdv = new ConsultorDeVendas(rs.getInt("id"), rs.getString("nome"),
								rs.getBigDecimal("valorBonusMensal"), rs.getString("nivel"), rs.getString("sexo"));
						funcionarios.add(cdv);
						cdv.setDependentes(dDAO.search(cdv));
					}
				} catch (NullPointerException | IllegalArgumentException e) {
					continue;
				}
			}
			return funcionarios;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		throw new NoSuchElementException("Nenhum funcionário cadastrado!");
	}

	public boolean delete(int id) {
		final String SQL = "delete from funcionario where id=?";
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(SQL)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return false;
	}
}