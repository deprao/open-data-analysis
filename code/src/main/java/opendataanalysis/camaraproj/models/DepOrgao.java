package opendataanalysis.camaraproj.models;

import java.util.Date;

public class DepOrgao {
    public Integer id_org;
    public Integer id_dep;
    public String sigla_partido;
    public String sigla_uf;
    public String cargo;
    public Date data_inicio;
    public Date data_fim;

    public DepOrgao(Integer id_org, Integer id_dep, String sigla_partido, String sigla_uf, String cargo, Date data_inicio, Date data_fim) {
        this.id_org = id_org;
        this.id_dep = id_dep;
        this.sigla_partido = sigla_partido;
        this.sigla_uf = sigla_uf;
        this.cargo = cargo;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public Integer getId_org() {
        return id_org;
    }

    public void setId_org(Integer id_org) {
        this.id_org = id_org;
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public String getSigla_partido() {
        return sigla_partido;
    }

    public void setSigla_partido(String sigla_partido) {
        this.sigla_partido = sigla_partido;
    }

    public String getsigla_uf() {
        return sigla_uf;
    }

    public void setsigla_uf(String sigla_uf) {
        this.sigla_uf = sigla_uf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getdata_inicio() {
        return data_inicio;
    }

    public void setdata_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
}
