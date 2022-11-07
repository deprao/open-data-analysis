package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.models.DepOrgao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import opendataanalysis.camaraproj.dao.*;
import org.springframework.ui.Model;

@Controller
public class UploadController {

    UploadLogDAO dao;
    EventoDAO eventodao;
    DepOcupDAO ocupdao;
    DepProDAO prodao;
    DeputadoDAO deputadodao;
    OrgaoDAO orgaodao;
    LegislaturaDAO legisdao;
    ReqDAO requerdao;
    DepOrgaoDAO cargodao;
    EventoPresDAO eventodepdao;
    EventoReqDAO eventoreqdao;
    OrgaoEventoDAO orgeventodao;
    VotacaoDAO votacaodao;

    @Autowired
    public UploadController(UploadLogDAO dao, EventoDAO eventodao, DepOcupDAO ocupdao, DepProDAO prodao, DeputadoDAO deputadodao, OrgaoDAO orgaodao, LegislaturaDAO legisdao, ReqDAO requerdao, DepOrgaoDAO cargodao, EventoPresDAO eventodepdao, EventoReqDAO eventoreqdao, OrgaoEventoDAO orgeventodao, VotacaoDAO votacaodao) {
        this.dao = dao;
        this.eventodao = eventodao;
        this.ocupdao = ocupdao;
        this.prodao = prodao;
        this.deputadodao = deputadodao;
        this.orgaodao = orgaodao;
        this.legisdao = legisdao;
        this.requerdao = requerdao;
        this.cargodao = cargodao;
        this.eventodepdao = eventodepdao;
        this.eventoreqdao = eventoreqdao;
        this.orgeventodao = orgeventodao;
        this.votacaodao = votacaodao;
    }

    @RequestMapping(value = "/Listar-cargas", method = RequestMethod.GET)
    public String listarCargas(Model mod){
        mod.addAttribute("cargas", dao.findAll());

        return "log";
    }

    @RequestMapping(value = "/Upload" ,method = RequestMethod.GET)
    public String index(){
        return "upload";
    }

    @RequestMapping(value = "/Upload" ,method = RequestMethod.POST)
    public String UploadArq(@RequestParam String tabela, String path){
        boolean verify = true;

        switch (tabela){
            case "legislatura":
                verify = legisdao.upload(path);
                return verify? "ok" : "erro";
            case "deputado":
                verify = deputadodao.upload(path);
                return verify? "ok" : "erro";
            case "evento":
                verify = eventodao.upload(path);
                return verify? "ok" : "erro";
            case "orgao":
                verify = orgaodao.upload(path);
                return verify? "ok" : "erro";
            case "requerimento":
                verify = requerdao.upload(path);
                return verify? "ok" : "erro";
            case "dep_ocupacao":
                verify = ocupdao.upload(path);
                return verify? "ok" : "erro";
            case "dep_profissao":
                verify = prodao.upload(path);
                return verify? "ok" : "erro";
            case "dep_trabalha_orgao":
                verify = cargodao.upload(path);
                return verify? "ok" : "erro";
            case "deputado_participa_evento":
                verify = eventodepdao.upload(path);
                return verify? "ok" : "erro";
            case "evento_requer_aprovacao":
                verify = eventoreqdao.upload(path);
                return verify? "ok" : "erro";
            case "orgao_realiza_evento":
                verify = orgeventodao.upload(path);
                return verify? "ok" : "erro";
            case "votacao":
                verify = votacaodao.upload(path);
                return verify? "ok" : "erro";
            default:
                return "erro";
        }
    }
}
