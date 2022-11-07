package opendataanalysis.camaraproj.models;

public class EventoReq {
    public Integer id_evento;
    public Integer id_requerimento;

    public EventoReq(Integer id_evento, Integer id_requerimento) {
        this.id_evento = id_evento;
        this.id_requerimento = id_requerimento;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public Integer getId_requerimento() {
        return id_requerimento;
    }

    public void setId_requerimento(Integer id_requerimento) {
        this.id_requerimento = id_requerimento;
    }
}
