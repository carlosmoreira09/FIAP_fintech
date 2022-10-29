package br.com.fintech.test;

import br.com.fintech.bean.Conta;
import br.com.fintech.dao.ContaDao;

public class TesteCriarConta {
    public static void main(String[] args) {
        ContaDao dao = new ContaDao();
        Conta conta = new Conta();

        int y = 5;
        while (y < 15) {
            conta.setNr_conta(y);
            conta.setNr_cpf("00100200510");
            conta.setNr_agencia(1075);
            dao.insert(conta);
            y++;
        }
    }
}
