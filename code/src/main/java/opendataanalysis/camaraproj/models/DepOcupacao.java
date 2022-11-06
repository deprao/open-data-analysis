package opendataanalysis.camaraproj.models;

public class DepOcupacao {
    private String titulo;
    private String entidade;
    private String ano_ini;
    private String ano_fim;
    private String UF_ent;
    private String pais_entidade;
    private Integer id_dep;

    public DepOcupacao(String titulo, String entidade, String ano_ini, String ano_fim, String UF_ent, String pais_entidade, Integer id_dep) {
        this.titulo = titulo;
        this.entidade = entidade;
        this.ano_ini = ano_ini;
        this.ano_fim = ano_fim;
        this.UF_ent = UF_ent;
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

    public String getAno_ini() {
        return ano_ini;
    }

    public void setAno_ini(String ano_ini) {
        this.ano_ini = ano_ini;
    }

    public String getAno_fim() {
        return ano_fim;
    }

    public void setAno_fim(String ano_fim) {
        this.ano_fim = ano_fim;
    }

    public String getUF_ent() {
        return UF_ent;
    }

    public void setUF_ent(String UF_ent) {
        this.UF_ent = UF_ent;
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
