package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.jdbc.FintechDB;

public class CadastroDao implements CadastroInterface {
    
    private Connection conexao;

    @Override
    public void cadastrar(Cadastro cadastro) {
        
        PreparedStatement stmt = null;
       
        try { 
            conexao = FintechDB.obterconexao();
            String sql = "INSERT INTO T_FIN_CADASTRO(NR_CPF, NM_EMAIL, NM_NOME) VALUES (?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cadastro.getNr_cpf());
            stmt.setString(2, cadastro.getNm_email());
            stmt.setString(3, cadastro.getNm_nome());
            
            stmt.executeUpdate();

        } catch(SQLException e) { 
            e.printStackTrace();
        } finally { 
            try { 
                stmt.close();
                conexao.close();
            } catch(SQLException e) { 
                e.printStackTrace();
            }
        }   
    }

    @Override
    public List<Cadastro> listar() {
        
        List<Cadastro> lista = new ArrayList<Cadastro>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try { 
            conexao = FintechDB.obterconexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_FIN_USER");
			rs = stmt.executeQuery();

            while(rs.next()) { 

                int id_conta = rs.getInt("id_conta");
                int nr_cpf = rs.getInt("nr_cpf");
                String nm_nome = rs.getString("nm_nome");
                String nm_email = rs.getString("nm_email");

                Cadastro cadastro = new Cadastro(id_conta, nr_cpf, nm_nome, nm_email);
                lista.add(cadastro);
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

        return null;
    }

    @Override
    public void atualizar(Cadastro cadastro) {
        PreparedStatement stmt = null;
        try { 
            conexao = FintechDB.obterconexao();
            String sql = "UPDATE T_FIN_CADASTRO SET NR_CPF = ?, NM_EMAIL = ?, NM_NOME = ? WHERE id_conta = ?";

            stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, cadastro.getNr_cpf());
            stmt.setString(2, cadastro.getNm_email());
            stmt.setString(3, cadastro.getNm_nome());
            stmt.setInt(4, cadastro.getId_conta());
            
            stmt.executeUpdate();

        } catch(SQLException e) { 
            e.printStackTrace();
        } finally { 
            try { 
                stmt.close();
                conexao.close();
            } catch(SQLException e) { 
                e.printStackTrace();
            }
        } 
        
    }

    @Override
    public void removerCadastro(int id_conta) {
       
        PreparedStatement stmt = null;
        try { 
            conexao = FintechDB.obterconexao();

            String sql = "DELETE FROM T_FIN_USER WHERE id_conta = ?";
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
    public Cadastro busCadastro(int id_conta) {
        // TODO Auto-generated method stub
        return null;
    }

 
}
