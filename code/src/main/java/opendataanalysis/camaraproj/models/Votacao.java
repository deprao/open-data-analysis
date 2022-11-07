package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Votacao {

    public String id_votacao;
    public Date data_votacao;
    public Integer id_org;
    public Integer aprovacao;
    public Integer votos_favor;
    public Integer votos_contra;
    public String desc_resultado;
    public String ultima_apresentacao_requerimento_descricao;
    public Integer id_requerimento;

    public Votacao(String id_votacao, Date data_votacao, Integer id_org, Integer aprovacao, Integer votos_favor, Integer votos_contra, String desc_resultado, String ultima_apresentacao_requerimento_descricao, Integer id_requerimento) {
        this.id_votacao = id_votacao;
        this.data_votacao = data_votacao;
        this.id_org = id_org;
        this.aprovacao = aprovacao;
        this.votos_favor = votos_favor;
        this.votos_contra = votos_contra;
        this.desc_resultado = desc_resultado;
        this.ultima_apresentacao_requerimento_descricao = ultima_apresentacao_requerimento_descricao;
        this.id_requerimento = id_requerimento;
    }

    public String getid_votacao() {
        return id_votacao;
    }

    public void setid_votacao(String id_votacao) {
        this.id_votacao = id_votacao;
    }

    public Date getData_votacao() {
        return data_votacao;
    }

    public void setData_votacao(Date data_votacao) {
        this.data_votacao = data_votacao;
    }

    public Integer getId_org() {
        return id_org;
    }

    public void setId_org(Integer id_org) {
        this.id_org = id_org;
    }

    public Integer getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Integer aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Integer getvotos_favor() {
        return votos_favor;
    }

    public void setvotos_favor(Integer votos_favor) {
        this.votos_favor = votos_favor;
    }

    public Integer getvotos_contra() {
        return votos_contra;
    }

    public void setvotos_contra(Integer votos_contra) {
        this.votos_contra = votos_contra;
    }

    public String getDesc_resultado() {
        return desc_resultado;
    }

    public void setDesc_resultado(String desc_resultado) {
        this.desc_resultado = desc_resultado;
    }

    public String getultima_apresentacao_requerimento_descricao() {
        return ultima_apresentacao_requerimento_descricao;
    }

    public void setultima_apresentacao_requerimento_descricao(String ultima_apresentacao_requerimento_descricao) {
        this.ultima_apresentacao_requerimento_descricao = ultima_apresentacao_requerimento_descricao;
    }

    public Integer getId_requerimento() {
        return id_requerimento;
    }

    public void setId_requerimento(Integer id_requerimento) {
        this.id_requerimento = id_requerimento;
    }
}
