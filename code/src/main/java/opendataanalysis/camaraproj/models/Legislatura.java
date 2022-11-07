package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Legislatura {


    public Integer id;
    public Date data_inicio;
    public Date data_fim;
    public Integer ano_eleicao;

    public Legislatura(Integer id, Date data_inicio, Date data_fim, Integer ano_eleicao) {
        this.id = id;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.ano_eleicao = ano_eleicao;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Integer getAno_eleicao() {
        return ano_eleicao;
    }

    public void setAno_eleicao(Integer ano_eleicao) {
        this.ano_eleicao = ano_eleicao;
    }
}
