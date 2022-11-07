package opendataanalysis.camaraproj.models;

import java.sql.Timestamp;
import java.util.Date;

public class Orgao {

    public Integer id;
    public String sigla;
    public String nome;
    public String tipo;
    public Timestamp data_inicio;
    public Timestamp data_instalacao;
    public Timestamp data_fim;
    public String descricao_situacao;
    public String casa;
    public String sala;

    public Orgao(Integer id, String sigla, String nome, String tipo, Timestamp data_inicio, Timestamp data_instalacao, Timestamp data_fim, String descricao_situacao, String casa, String sala) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.tipo = tipo;
        this.data_inicio = data_inicio;
        this.data_instalacao = data_instalacao;
        this.data_fim = data_fim;
        this.descricao_situacao = descricao_situacao;
        this.casa = casa;
        this.sala = sala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Timestamp data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Timestamp getData_instalacao() {
        return data_instalacao;
    }

    public void setData_instalacao(Timestamp data_instalacao) {
        this.data_instalacao = data_instalacao;
    }

    public Timestamp getData_fim() {
        return data_fim;
    }

    public void setData_fim(Timestamp data_fim) {
        this.data_fim = data_fim;
    }

    public String getDescricao_situacao() {
        return descricao_situacao;
    }

    public void setDescricao_situacao(String descricao_situacao) {
        this.descricao_situacao = descricao_situacao;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
