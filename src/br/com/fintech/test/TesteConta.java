package br.com.fintech.test;

import java.util.List;


import br.com.fintech.bean.Conta;
import br.com.fintech.dao.ContaDao;

public class TesteConta {
    
    public static void main(String[] args) {

		ContaDao dao = new ContaDao();

		List<Conta> lista = dao.listar();
		for (Conta agencia : lista) {
			System.out.println(
								"Conta Numero:" + agencia.getNr_conta() + 
								"\n" + 
								"Agencia Numero:" + agencia.getNr_agencia()
							);
		}

	}
}
