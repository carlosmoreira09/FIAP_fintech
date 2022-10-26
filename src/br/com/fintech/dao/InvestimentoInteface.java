package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Investimento;

public interface InvestimentoInteface {

    public void cadastrarInvestimento(Investimento investimento);
    
    public List<Investimento> listar();

    public void removerInvestimento(int id_investimento);

    public void atualizarInvestimento(Investimento investimento);
    
    public Investimento busInvestimento(int id_investimento);
}
