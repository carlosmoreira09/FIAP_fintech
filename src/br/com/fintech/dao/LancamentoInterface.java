package br.com.fintech.dao;
import java.util.List;

import br.com.fintech.bean.Lancamento;

public interface LancamentoInterface {

    public void cadastrarLancamento(Lancamento lancamento);
    
    public List<Lancamento> listar();

    public void removerLancamento(int id_lancamento);

    public void atualizarLancamento(Lancamento lancamento);
    
    public Lancamento busLancamento(int id_lancamento);
}
