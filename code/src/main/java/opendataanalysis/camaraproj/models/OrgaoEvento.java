package opendataanalysis.camaraproj.models;

public class OrgaoEvento {

    public Integer id_evento;
    public Integer id_org;

    public OrgaoEvento(Integer id_evento, Integer id_org) {
        this.id_evento = id_evento;
        this.id_org = id_org;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public Integer getId_org() {
        return id_org;
    }

    public void setId_org(Integer id_org) {
        this.id_org = id_org;
    }
}
