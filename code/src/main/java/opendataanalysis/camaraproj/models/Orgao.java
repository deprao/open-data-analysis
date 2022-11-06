package opendataanalysis.camaraproj.models;

//import java.security.Timestamp;
import java.util.Date;

public class Orgao {

    private Integer id;
    private String sigla;
    private String nome;
    private String tipo;
    private Date data_ini;
    private Date data_inst;
    private Date data_fim;
    private String desc_situacao;
    private String casa;
    private String sala;

    public Orgao(Integer id, String sigla, String nome, String tipo, Date data_ini, Date data_inst, Date data_fim, String desc_situacao, String casa, String sala) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.tipo = tipo;
        this.data_ini = data_ini;
        this.data_inst = data_inst;
        this.data_fim = data_fim;
        this.desc_situacao = desc_situacao;
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

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Date getData_inst() {
        return data_inst;
    }

    public void setData_inst(Date data_inst) {
        this.data_inst = data_inst;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getDesc_situacao() {
        return desc_situacao;
    }

    public void setDesc_situacao(String desc_situacao) {
        this.desc_situacao = desc_situacao;
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
