package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Cadastro;

public interface CadastroInterface {
    
    public void cadastrar(Cadastro cadastro);
    
    public List<Cadastro> listar();

    public void removerCadastro(int nr_cpf);

    public void atualizar(Cadastro cadastro);
    
    public Cadastro busCadastro(int nr_cpf);
    
}
