package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Evento {

    private Integer id;
    private Date data_hora_inicio;
    private Date data_hora_fim;
    private String situacao;
    private String descricao;
    private String descricao_tipo;
    private String localizacao;

    public Evento(Integer id, Date data_hora_inicio, Date data_hora_fim, String situacao, String descricao, String descricao_tipo, String localizacao) {
        this.id = id;
        this.data_hora_inicio = data_hora_inicio;
        this.data_hora_fim = data_hora_fim;
        this.situacao = situacao;
        this.descricao = descricao;
        this.descricao_tipo = descricao_tipo;
        this.localizacao = localizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_hora_inicio() {
        return data_hora_inicio;
    }

    public void setData_hora_inicio(Date data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public Date getData_hora_fim() {
        return data_hora_fim;
    }

    public void setData_hora_fim(Date data_hora_fim) {
        this.data_hora_fim = data_hora_fim;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao_tipo() {
        return descricao_tipo;
    }

    public void setDescricao_tipo(String descricao_tipo) {
        this.descricao_tipo = descricao_tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
