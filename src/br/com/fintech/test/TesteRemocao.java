package br.com.fintech.test;


import br.com.fintech.dao.CadastroDao;

public class TesteRemocao {
    public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();
			dao.removerCadastro(dao.busCadastro("00100200210"));
			System.out.println("Removido Cadastro");
	}
}
