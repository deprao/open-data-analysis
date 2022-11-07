package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Deputado {

    public Integer id_dep;
    public String nome_parlamentar;
    public String nome_civil;
    public Date data_nasc;
    public Date data_falec;
    public String sexo;
    public String uf_nasc;
    public String municipio_nasc;
    public Integer id_ultima_legislatura;

    public Deputado(Integer id_dep, String nome_parlamentar, String nome_civil, Date data_nasc, Date data_falec, String sexo, String uf_nasc, String municipio_nasc, Integer id_ultima_legislatura) {
        this.id_dep = id_dep;
        this.nome_parlamentar = nome_parlamentar;
        this.nome_civil = nome_civil;
        this.data_nasc = data_nasc;
        this.data_falec = data_falec;
        this.sexo = sexo;
        this.uf_nasc = uf_nasc;
        this.municipio_nasc = municipio_nasc;
        this.id_ultima_legislatura = id_ultima_legislatura;
    }

    public Integer getId() {
        return id_dep;
    }

    public void setId(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public String getNome_parlamentar() {
        return nome_parlamentar;
    }

    public void setNome_parlamentar(String nome_parlamentar) {
        this.nome_parlamentar = nome_parlamentar;
    }

    public String getNome_civil() {
        return nome_civil;
    }

    public void setNome_civil(String nome_civil) {
        this.nome_civil = nome_civil;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Date getData_falec() {
        return data_falec;
    }

    public void setData_falec(Date data_falec) {
        this.data_falec = data_falec;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUF_nasc() {
        return uf_nasc;
    }

    public void setUF_nasc(String uf_nasc) {
        this.uf_nasc = uf_nasc;
    }

    public String getMunicipio_nasc() {
        return municipio_nasc;
    }

    public void setMunicipio_nasc(String municipio_nasc) {
        this.municipio_nasc = municipio_nasc;
    }

    public Integer getId_ultima_legislatura() {
        return id_ultima_legislatura;
    }

    public void setId_ultima_legislatura(Integer id_ultima_legislatura) {
        this.id_ultima_legislatura = id_ultima_legislatura;
    }
}
