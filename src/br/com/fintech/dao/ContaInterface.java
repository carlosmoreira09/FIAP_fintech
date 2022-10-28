package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Conta;

public interface ContaInterface {
    
    public void insert(Conta conta);
    
    public List<Conta> getAll(String nr_cpf);

    public void removerConta(int id_conta);

    public void atualizarConta(Conta conta);
    
    public Conta busConta(int id_conta);
    
}