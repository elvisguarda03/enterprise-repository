package br.com.guacom.enterprise.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.guacom.enterprise.model.ConnectionFactory;
import br.com.guacom.enterprise.model.Dependente;
import br.com.guacom.enterprise.model.Funcionario;

public class DependenteDAO {

	public boolean insert(Dependente dependente) {
		String sql = "insert into dependente (nome, cod_funcionario) values (?,?)";
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setString(1, dependente.getNome());
			stmt.setInt(2, dependente.getFuncionario().getIdFuncionario());
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(List<Dependente> dependentes) {
		boolean isRight = false;
		for (Dependente d : dependentes)
			isRight = insert(d);
		return isRight;
	}

	public List<Dependente> search(Funcionario f) {
		String sql = "select * from dependente d where d.cod_funcionario = ?";
		List<Dependente> dependentes = new ArrayList<>();
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
			stmt.setInt(1, f.getIdFuncionario());
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Dependente d = new Dependente(rs.getInt("id"), rs.getString("nome"), f);
					dependentes.add(d);
				}
				return dependentes;
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		throw new IllegalArgumentException("Este funcionário não possui dependentes.");
	}

	public boolean delete(int id) {
		final String SQL = "delete from dependente where id=?";
		return remove(id, SQL);
	}

	private boolean remove(int id, final String SQL) {
		try(PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(SQL)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			System.out.println(String.format("Erro: %s", e.getMessage()));
		}
		return false;
	}
	
	public boolean delete(Funcionario f) {
		final String SQL = "delete from dependente where cod_funcionario = ?";
		return remove(f.getIdFuncionario(), SQL);
	}

	public boolean update(Dependente d) {
		final String SQL = "update dependente set nome=? where id=?";
		try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(SQL)) {
			stmt.setString(1, d.getNome());
			stmt.setInt(2, d.getIdDependente());
			stmt.executeUpdate();
			return stmt.getUpdateCount() > 0;
		} catch (SQLException e) {
			System.out.println(String.format("Erro: %s", e.getMessage()));
		}
		return false;
	}
}