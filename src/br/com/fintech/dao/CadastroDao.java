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
    public void insert(Cadastro cadastro) {
        
        PreparedStatement stmt = null;
       
        try { 
            conexao = FintechDB.obterconexao();
            String sql = "INSERT INTO T_FIN_USER(NR_CPF, NM_EMAIL, NM_NOME) VALUES (?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getNr_cpf());
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
    public List<Cadastro> getAll() {
        
        List<Cadastro> lista = new ArrayList<Cadastro>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try { 
            conexao = FintechDB.obterconexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_FIN_USER");
			rs = stmt.executeQuery();

            while(rs.next()) { 

                String nr_cpf = rs.getString("nr_cpf");
                String nm_nome = rs.getString("nm_nome");
                String nm_email = rs.getString("nm_email");

                Cadastro cadastro = new Cadastro(nr_cpf, nm_nome, nm_email);
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

        return lista;
    }

    @Override
    public void atualizar(Cadastro cadastro) {
        PreparedStatement stmt = null;
        try {
            conexao = FintechDB.obterconexao();
            String sql = "UPDATE T_FIN_USER SET NM_EMAIL = ?, NM_NOME = ? WHERE nr_cpf = ?";

            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cadastro.getNm_email());
            stmt.setString(2, cadastro.getNm_nome());
            stmt.setString(3, cadastro.getNr_cpf());

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
    public void removerCadastro(Cadastro cadastro) {
       
        PreparedStatement stmt = null;
        try { 
            conexao = FintechDB.obterconexao();

            String sql = "DELETE FROM T_FIN_USER WHERE nr_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cadastro.getNr_cpf());
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
    public Cadastro busCadastro(String nr_cpf) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nm_nome = null;
        String nm_email = null;
        try {
            conexao = FintechDB.obterconexao();
            stmt = conexao.prepareStatement("SELECT nm_nome, nm_email FROM T_FIN_USER WHERE nr_cpf = ?");
            stmt.setString(1, nr_cpf);
            rs = stmt.executeQuery();
            rs.next();

            nm_nome = rs.getString("nm_nome");
            nm_email = rs.getString("nm_email");

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
        return new Cadastro(nr_cpf, nm_nome, nm_email);
    }
}
