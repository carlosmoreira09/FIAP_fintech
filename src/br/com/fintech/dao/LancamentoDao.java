package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Lancamento;
import br.com.fintech.jdbc.FintechDB;

public class LancamentoDao implements LancamentoInterface {
    
    private Connection conexao;

    @Override
    public void cadastrarLancamento(Lancamento lancamento) {
        
        PreparedStatement stmt = null;
	
			try {
				conexao = FintechDB.obterconexao();
				String sql = "INSERT INTO T_FIN_LANCAMENTOS(vl_lancamento, dt_data) VALUES (?, ?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, lancamento.getVl_lancamento());
				stmt.setDate(2, lancamento.getDt_data());
			
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
    public List<Lancamento> listar() {
        List<Lancamento> lista = new ArrayList<Lancamento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_LANCAMENTOS");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int id_conta = rs.getInt("id_conta");
				int id_lancamento = rs.getInt("id_lancamento");
				int vl_lancamento = rs.getInt("vl_lancamento");
				Date dt_data = rs.getDate("dt_data");

				Lancamento lancamento = new Lancamento(id_lancamento, id_conta, vl_lancamento, dt_data)    ;
				lista.add(lancamento);
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
    public void atualizarLancamento(Lancamento lancamento) {
        PreparedStatement stmt = null;
	
        try {
            conexao = FintechDB.obterconexao();
            String sql = "UPDATE T_FIN_LANCAMENTOS SET vl_lancamento = ?, dt_data = ? WHERE id_lancamento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, lancamento.getVl_lancamento());
            stmt.setDate(2, lancamento.getDt_data());
            stmt.setInt(3, lancamento.getId_lancamento());
        
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
    public void removerLancamento(int id_lancamento) {
        
        PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_LANCAMENTOS WHERE id_lancamento = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id_lancamento);
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
    public Lancamento busLancamento(int id_lancamento) {

        Lancamento lancamento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_LANCAMENTOS WHERE id_lancamento = ?");
			stmt.setInt(1, id_lancamento);
			rs = stmt.executeQuery();

			if (rs.next()) {

				int id_conta = rs.getInt("id_conta");
				int vl_lancamento = rs.getInt("vl_lancamento");
				Date dt_data = rs.getDate("dt_data");

				lancamento = new Lancamento(id_lancamento,id_conta, vl_lancamento, dt_data);
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
		return lancamento;
    }
    
}
