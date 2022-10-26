package br.com.fintech.test;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteUpdate {
    public static void main(String[] args) {

		CadastroDao dao = new CadastroDao();

		Cadastro cadastro = dao.busCadastro(2);

		System.out.println("Id Conta: " + cadastro.getId_conta() + 
                            "\nNome: " + cadastro.getNm_nome() + 
                            "\nEmail: "	+ cadastro.getNm_email() + 
                            "\nCPF: " + cadastro.getNr_cpf() 
                            );

		cadastro.setNm_nome("Lucas Barbosa");
		cadastro.setNm_email("LucasBarbosa@gmail.com");

		dao.atualizar(cadastro);

	}
}
