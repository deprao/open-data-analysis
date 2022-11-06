package opendataanalysis.camaraproj.models;

public class EventoReq {
    private Integer id_dep;
    private Integer id_req;

    public EventoReq(Integer id_dep, Integer id_req) {
        this.id_dep = id_dep;
        this.id_req = id_req;
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public Integer getId_req() {
        return id_req;
    }

    public void setId_req(Integer id_req) {
        this.id_req = id_req;
    }
}
