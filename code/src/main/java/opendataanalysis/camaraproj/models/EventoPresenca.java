package opendataanalysis.camaraproj.models;

public class EventoPresenca {

    public Integer id_dep;
    public Integer id_evento;

    public EventoPresenca(Integer id_dep, Integer id_evento) {
        this.id_dep = id_dep;
        this.id_evento = id_evento;
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }
}
