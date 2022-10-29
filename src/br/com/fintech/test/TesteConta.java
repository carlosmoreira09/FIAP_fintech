package br.com.fintech.test;

import java.util.List;


import br.com.fintech.bean.Conta;
import br.com.fintech.dao.ContaDao;

public class TesteConta {
    
    public static void main(String[] args) {

		ContaDao dao = new ContaDao();
		String nr_cpf = "00100200510";

		List<Conta> lista = dao.getAll(nr_cpf);
		for (Conta agencia : lista) {
			System.out.println(
					"\n" +
					"Conta Numero:" + agencia.getNr_conta() +
					"\n" +
					"Agencia Numero:" + agencia.getNr_agencia() +
					"\n" +
					"ID:" + agencia.getId_conta() +
					"\n" +
					"CPF:" + agencia.getNr_cpf()
			);
		}
	}
}
