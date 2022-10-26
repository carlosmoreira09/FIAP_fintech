package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Conta;

public interface ContaInterface {
    
    public void cadastrarConta(Conta conta);
    
    public List<Conta> listar();

    public void removerConta(int id_conta);

    public void atualizarConta(Conta conta);
    
    public Conta busConta(int id_conta);
    
}