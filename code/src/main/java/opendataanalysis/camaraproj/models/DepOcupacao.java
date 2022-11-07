package opendataanalysis.camaraproj.models;

public class DepOcupacao {
    public String titulo;
    public String entidade;
    public String ano_inicio;
    public String ano_fim;
    public String uf_entidade;
    public String pais_entidade;
    public Integer id_dep;

    public DepOcupacao(String titulo, String entidade, String ano_inicio, String ano_fim, String uf_entidade, String pais_entidade, Integer id_dep) {
        this.titulo = titulo;
        this.entidade = entidade;
        this.ano_inicio = ano_inicio;
        this.ano_fim = ano_fim;
        this.uf_entidade = uf_entidade;
        this.pais_entidade = pais_entidade;
        this.id_dep = id_dep;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getAno_inicio() {
        return ano_inicio;
    }

    public void setAno_inicio(String ano_inicio) {
        this.ano_inicio = ano_inicio;
    }

    public String getAno_fim() {
        return ano_fim;
    }

    public void setAno_fim(String ano_fim) {
        this.ano_fim = ano_fim;
    }

    public String getuf_entidade() {
        return uf_entidade;
    }

    public void setuf_entidade(String uf_entidade) {
        this.uf_entidade = uf_entidade;
    }

    public String getPais_entidade() {
        return pais_entidade;
    }

    public void setPais_entidade(String pais_entidade) {
        this.pais_entidade = pais_entidade;
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }
}
