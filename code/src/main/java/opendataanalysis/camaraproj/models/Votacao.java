package opendataanalysis.camaraproj.models;

import java.util.Date;

public class Votacao {

    private String id_vot;
    private Date data_vot;
    private Integer id_org;
    private Integer aprov;
    private Integer vote_up;
    private Integer vote_down;
    private String desc_result;
    private String ultima_req;
    private Integer id_req;

    public Votacao(String id_vot, Date data_vot, Integer id_org, Integer aprov, Integer vote_up, Integer vote_down, String desc_result, String ultima_req, Integer id_req) {
        this.id_vot = id_vot;
        this.data_vot = data_vot;
        this.id_org = id_org;
        this.aprov = aprov;
        this.vote_up = vote_up;
        this.vote_down = vote_down;
        this.desc_result = desc_result;
        this.ultima_req = ultima_req;
        this.id_req = id_req;
    }

    public String getId_vot() {
        return id_vot;
    }

    public void setId_vot(String id_vot) {
        this.id_vot = id_vot;
    }

    public Date getData_vot() {
        return data_vot;
    }

    public void setData_vot(Date data_vot) {
        this.data_vot = data_vot;
    }

    public Integer getId_org() {
        return id_org;
    }

    public void setId_org(Integer id_org) {
        this.id_org = id_org;
    }

    public Integer getAprov() {
        return aprov;
    }

    public void setAprov(Integer aprov) {
        this.aprov = aprov;
    }

    public Integer getVote_up() {
        return vote_up;
    }

    public void setVote_up(Integer vote_up) {
        this.vote_up = vote_up;
    }

    public Integer getVote_down() {
        return vote_down;
    }

    public void setVote_down(Integer vote_down) {
        this.vote_down = vote_down;
    }

    public String getDesc_result() {
        return desc_result;
    }

    public void setDesc_result(String desc_result) {
        this.desc_result = desc_result;
    }

    public String getUltima_req() {
        return ultima_req;
    }

    public void setUltima_req(String ultima_req) {
        this.ultima_req = ultima_req;
    }

    public Integer getId_req() {
        return id_req;
    }

    public void setId_req(Integer id_req) {
        this.id_req = id_req;
    }
}
