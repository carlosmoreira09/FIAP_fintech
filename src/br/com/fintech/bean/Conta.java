package br.com.fintech.bean;

public class Conta {

    private int id_conta;
    private int nr_cpf;
    private int nr_agencia;
    private int nr_conta;
    
    public Conta(int id_conta, int nr_cpf, int nr_agencia, int nr_conta) {
        
        super();
        this.id_conta = id_conta;
        this.nr_agencia = nr_agencia;
        this.nr_conta = nr_conta;
        this.nr_cpf = nr_cpf;
    }

    public Conta() {
        super();
    }
    
    public int getId_conta(){ 
        return id_conta;
    }

    public int getNr_cpf() { 
        return nr_cpf;
    }

    public void setNr_cpf(int nr_cpf) { 
        this.nr_cpf = nr_cpf;
    }

    public int getNr_agencia() { 
        return nr_agencia;
    }

    public void setNr_agencia(int nr_agencia) { 
        this.nr_agencia = nr_agencia;
    }
    public int getNr_conta() { 
        return nr_conta;
    }

    public void setNr_conta(int nr_conta) { 
        this.nr_conta = nr_conta;
    }
}
