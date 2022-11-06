package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Legislatura {


    private Integer id;
    private Date data_ini;
    private Date data_fim;
    private Integer ano_elec;

    public Legislatura(Integer id, Date data_ini, Date data_fim, Integer ano_elec) {
        this.id = id;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
        this.ano_elec = ano_elec;
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

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Integer getAno_elec() {
        return ano_elec;
    }

    public void setAno_elec(Integer ano_elec) {
        this.ano_elec = ano_elec;
    }
}
