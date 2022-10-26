package br.com.fintech.bean;

import java.sql.Date;

public class Lancamento {

    private int id_conta;
    private int id_lancamento;
    private int vl_lancamento;
    private Date dt_data;

    public Lancamento(int id_lancamento, int id_conta, int vl_lancamento, Date dt_data){ 
        super();
        this.id_conta = id_conta;
        this.id_lancamento = id_lancamento;
        this.vl_lancamento = vl_lancamento;
        this.dt_data = dt_data;
    }

    public Lancamento() {}

    public int getId_conta(){
        return id_conta;
    }

    public int getId_lancamento(){ 
        return id_lancamento;
    }

    public int getVl_lancamento() {
        return vl_lancamento;
    }

    public void setVl_lancamento(int vl_lancamento) { 
        this.vl_lancamento = vl_lancamento;
    }

    public Date getDt_data() { 
        return dt_data;
    }

    public void setDt_data(Date dt_data) { 
        this.dt_data = dt_data;
    }
}
