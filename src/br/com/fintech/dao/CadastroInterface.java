package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Cadastro;

public interface CadastroInterface {
    
    public void insert(Cadastro cadastro);
    
    public List<Cadastro> getAll();

    public void removerCadastro(Cadastro cadastro);

    public void atualizar(Cadastro cadastro);
    
    public Cadastro busCadastro(String nr_cpf);
    
}
