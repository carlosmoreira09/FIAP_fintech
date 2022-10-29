package  br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Investimento;

public interface InvestimentoInteface {

    public void insert(Investimento investimento);
    
    public List<Investimento> getAll();

    public void removerInvestimento(int id_investimento);

    public void atualizarInvestimento(Investimento investimento);
    
    public Investimento busInvestimento(int id_investimento);
}
