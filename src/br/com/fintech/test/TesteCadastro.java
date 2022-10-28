package br.com.fintech.test;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteCadastro {
    public static void main(String[] args) {

		CadastroDao dao = new CadastroDao();
        int y = 4;
		while (y < 5) {

			Cadastro cadastro = new Cadastro();
			cadastro.setNm_nome("Jorge Luis Jesus");
			cadastro.setNm_email("jorgeluiz@devsolutions.com");
			cadastro.setNr_cpf("00100200310");

			dao.insert(cadastro);

			System.out.println("Usuário Cadastrado #" + y);
			y++;
		}
	}
}
