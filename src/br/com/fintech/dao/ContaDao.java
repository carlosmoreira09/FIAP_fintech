package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Conta;
import br.com.fintech.jdbc.FintechDB;

public class ContaDao implements ContaInterface {
	
	private Connection conexao;
	
	@Override
		public void cadastrarConta(Conta conta) {
			
			PreparedStatement stmt = null;
	
			try {
				conexao = FintechDB.obterconexao();
				String sql = "INSERT INTO T_FIN_CONTA(nr_cpf, nr_agencia, nr_conta) VALUES (?, ?, ?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, conta.getNr_cpf());
				stmt.setInt(2, conta.getNr_agencia());
				stmt.setInt(3, conta.getNr_conta());
	
				stmt.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
		}		

	@Override
	public List<Conta> listar(String cpf) {
		
		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA WHERE nr_cpf = ?");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int id_conta = rs.getInt("id_conta");
				int nr_cpf = rs.getInt("nr_cpf");
				int nr_agencia = rs.getInt("nr_agencia");
				int nr_conta = rs.getInt("nr_conta");

				Conta conta = new Conta(id_conta, nr_cpf, nr_agencia, nr_conta);
				lista.add(conta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}

	@Override
	public void atualizarConta(Conta conta) {
		PreparedStatement stmt = null;
	
		try {
			conexao = FintechDB.obterconexao();
			String sql = "UPDATE T_FIN_CONTA SET nr_cpf = ?, nr_agencia = ?, nr_conta = ? WHERE id_conta = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getNr_cpf());
			stmt.setInt(2, conta.getNr_agencia());
			stmt.setInt(3, conta.getNr_conta());
			stmt.setInt(4, conta.getId_conta());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removerConta(int id_conta) {

		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_CONTA WHERE id_conta = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id_conta);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	

	@Override
	public Conta busConta(int nr_cpf) {
		Conta conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA WHERE nr_cpf = ?");
			stmt.setInt(1, nr_cpf);
			rs = stmt.executeQuery();

			if (rs.next()) {

				int id_conta = rs.getInt("id_conta");
				int nr_agencia = rs.getInt("nr_agencia");
				int nr_conta = rs.getInt("nr_conta");

				conta = new Conta(id_conta, nr_cpf, nr_agencia, nr_conta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conta;
	}
	
}