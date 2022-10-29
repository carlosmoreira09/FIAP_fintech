package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Investimento;
import br.com.fintech.jdbc.FintechDB;

public class InvestimentoDao implements InvestimentoInteface {
	
    private Connection conexao;

    @Override
    public void insert(Investimento investimento) {
        
        PreparedStatement stmt = null;
	
			try {
				conexao = FintechDB.obterconexao();
				String sql = "INSERT INTO T_FIN_INVESTIMENTOS(vl_investimento, vl_variacao) VALUES (?, ?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, investimento.getVl_investimento());
				stmt.setInt(2, investimento.getVl_variacao());
				
	
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
    public List<Investimento> getAll() {
        List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTOS");
			rs = stmt.executeQuery();

			while (rs.next()) {

				int id_conta = rs.getInt("id_conta");
				int id_investimento = rs.getInt("id_investimento");
				int vl_investimento = rs.getInt("vl_investimento");
				int vl_variacao = rs.getInt("vl_variacao");

				Investimento investimento = new Investimento(id_investimento, id_conta, vl_investimento, vl_variacao)    ;
				lista.add(investimento);
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
    public void atualizarInvestimento(Investimento investimento) {
        PreparedStatement stmt = null;
	
        try {
            conexao = FintechDB.obterconexao();
            String sql = "UPDATE T_FIN_INVESTIMENTOS SET vl_investimento = ?, vl_variacao = ? WHERE id_investimento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, investimento.getVl_investimento());
            stmt.setInt(2, investimento.getVl_variacao());
            stmt.setInt(3, investimento.getId_investimento());
            

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
    public void removerInvestimento(int id_investimento) {
        PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_INVESTIMENTOS WHERE id_investimento = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id_investimento);
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
    public Investimento busInvestimento(int id_investimento) {
        Investimento investimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTOS WHERE id_investimento = ?");
			stmt.setInt(1, id_investimento);
			rs = stmt.executeQuery();

			if (rs.next()) {

				int id_conta = rs.getInt("id_conta");
				int vl_investimento = rs.getInt("vl_investimento");
				int vl_variacao = rs.getInt("vl_investimento");

				investimento = new Investimento(id_investimento,id_conta, vl_investimento, vl_variacao);
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
		return investimento;
    }
    
}
