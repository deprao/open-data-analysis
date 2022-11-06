package opendataanalysis.camaraproj.models;

import java.util.Date;

public class DepOrgao {
    private Integer id_org;
    private Integer id_dep;
    private String sigla_partido;
    private String UF;
    private String cargo;
    private Date data_ini;
    private Date data_fim;

    public DepOrgao(Integer id_org, Integer id_dep, String sigla_partido, String UF, String cargo, Date data_ini, Date data_fim) {
        this.id_org = id_org;
        this.id_dep = id_dep;
        this.sigla_partido = sigla_partido;
        this.UF = UF;
        this.cargo = cargo;
        this.data_ini = data_ini;
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

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
}
