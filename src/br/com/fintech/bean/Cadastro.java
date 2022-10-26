package br.com.fintech.bean;

public class Cadastro {
    
    private int id_conta;
    private int nr_cpf;
    private String nm_email;
    private String nm_nome;

    public Cadastro(int id_conta, int nr_cpf, String nm_nome, String nm_email) {
        super();

        this.id_conta = id_conta;
        this.nr_cpf = nr_cpf;
        this.nm_nome = nm_nome;
        this.nm_email = nm_email;
    }

    public Cadastro() {
        super();
    }
    
    public int getId_conta() { 
        return id_conta;
    }
    public int getNr_cpf() { 
        return nr_cpf;
    }

    public void setNr_cpf(int nr_cpf) {
        this.nr_cpf = nr_cpf;
    }

    public String getNm_email() { 
        return nm_email;
    }

    public void setNm_email(String nm_email) { 
        this.nm_email = nm_email;
    }

    public String getNm_nome() {
        return nm_nome;
    }

    public void setNm_nome(String nm_nome) { 
        this.nm_nome = nm_nome;
    }
}
