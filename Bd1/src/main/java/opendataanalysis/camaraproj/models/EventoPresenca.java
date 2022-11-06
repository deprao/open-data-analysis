package opendataanalysis.camaraproj.models;

public class EventoPresenca {

    private Integer id_dep;
    private Integer id_eve;

    public EventoPresenca(Integer id_dep, Integer id_eve) {
        this.id_dep = id_dep;
        this.id_eve = id_eve;
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public Integer getId_eve() {
        return id_eve;
    }

    public void setId_eve(Integer id_eve) {
        this.id_eve = id_eve;
    }
}
