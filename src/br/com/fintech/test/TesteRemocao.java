package br.com.fintech.test;


import br.com.fintech.dao.CadastroDao;

public class TesteRemocao {
    public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();
		int i = 1;
		int y = 1;

		while (i < 5){

			dao.removerCadastro("");
			System.out.println("Removido Cadastro:" + y);
            i++;
            y++;
		}   

	}
}
