package br.com.fintech.bean;

public class Investimento {

    private int id_investimento;
    private int id_conta;
    private int vl_investimento;
    private int vl_variacao;

    public Investimento(int id_investimento, int id_conta, int vl_investimento, int vl_variacao){ 
        super();

        this.id_conta = id_conta;
        this.id_investimento = id_investimento;
        this.vl_investimento = vl_investimento;
        this.vl_variacao = vl_variacao;
    }

    public Investimento () { 
        super();
    }

    public int getId_conta() {
        return id_conta;
    }

    public int getId_investimento () { 
        return id_investimento;
    }

    public int getVl_investimento() {
        return vl_investimento;
    }

    public void setVl_investimento(int vl_investimento) { 
        this.vl_investimento = vl_investimento;
    }

    public int getVl_variacao() { 
        return vl_variacao;
    }

    public void setVl_variacao(int vl_variacao) { 
        this.vl_variacao = vl_variacao;
    }
}
