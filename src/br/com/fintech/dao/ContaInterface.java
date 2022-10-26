package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Conta;

public interface ContaInterface {
    
    public void cadastrarConta(Conta conta);
    
    public List<Conta> listar();

    public void removerConta(int nr_cpf);

    public void atualizarConta(Conta conta);
    
    public Conta busConta(int nr_cpf);
    
}