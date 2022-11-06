package opendataanalysis.camaraproj.models;

public class OrgaoEvento {

    private Integer id_eve;
    private Integer id_org;

    public OrgaoEvento(Integer id_eve, Integer id_org) {
        this.id_eve = id_eve;
        this.id_org = id_org;
    }

    public Integer getId_eve() {
        return id_eve;
    }

    public void setId_eve(Integer id_eve) {
        this.id_eve = id_eve;
    }

    public Integer getId_org() {
        return id_org;
    }

    public void setId_org(Integer id_org) {
        this.id_org = id_org;
    }
}
