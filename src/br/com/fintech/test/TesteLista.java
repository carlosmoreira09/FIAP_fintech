package br.com.fintech.test;

import java.util.List;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteLista {
    
    public static void main(String[] args) {

		CadastroDao dao = new CadastroDao();

		List<Cadastro> lista = dao.listar();
		for (Cadastro item : lista) {

			System.out.println(
								"\n---------------------------" +
								"\nNome: " + item.getNm_nome() + 
								"\nE-mail: " + item.getNm_email() + 
								"\nCPF: " + item.getNr_cpf() + 
								"\n---------------------------");
		}

	}

}
