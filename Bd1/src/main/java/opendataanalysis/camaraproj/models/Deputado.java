package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Deputado {

    private Integer id;
    private String nome_parlamentar;
    private String nome_civil;
    private Date data_nasc;
    private Date data_falec;
    private String sexo;
    private String UF_nasc;
    private String municipio_nasc;
    private Integer id_ultima_legislatura;

    public Deputado(Integer id, String nome_parlamentar, String nome_civil, Date data_nasc, Date data_falec, String sexo, String UF_nasc, String municipio_nasc, Integer id_ultima_legislatura) {
        this.id = id;
        this.nome_parlamentar = nome_parlamentar;
        this.nome_civil = nome_civil;
        this.data_nasc = data_nasc;
        this.data_falec = data_falec;
        this.sexo = sexo;
        this.UF_nasc = UF_nasc;
        this.municipio_nasc = municipio_nasc;
        this.id_ultima_legislatura = id_ultima_legislatura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return UF_nasc;
    }

    public void setUF_nasc(String UF_nasc) {
        this.UF_nasc = UF_nasc;
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
