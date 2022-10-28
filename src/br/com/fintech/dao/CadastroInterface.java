package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Cadastro;

public interface CadastroInterface {
    
    public void insert(Cadastro cadastro);
    
    public List<Cadastro> listar();

    public void removerCadastro(String nr_cpf);

    public void atualizar(Cadastro cadastro);
    
    public Cadastro busCadastro(String nr_cpf);
    
}
