package opendataanalysis.camaraproj.models;

import java.sql.Timestamp;
import java.util.Date;

public class DepProfissao {
    public Integer id_dep;
    public Integer cod_tipo;
    public String titulo;
    public Timestamp data_hora_registro;

    public DepProfissao(Integer id_dep, Integer cod_tipo, String titulo, Timestamp data_hora_registro) {
        this.id_dep = id_dep;
        this.cod_tipo = cod_tipo;
        this.titulo = titulo;
        this.data_hora_registro = data_hora_registro;
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public Integer getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(Integer cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Timestamp getData_hora_registro() {
        return data_hora_registro;
    }

    public void setData_hora_registro(Timestamp data_hora_registro) {
        this.data_hora_registro = data_hora_registro;
    }
}
