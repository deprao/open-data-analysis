package opendataanalysis.camaraproj.controller;

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

    @Autowired
    UploadLogDAO dao;

    @RequestMapping(value = "/Listar-cargas", method = RequestMethod.GET)
    public String listarCargas(Model mod){
        mod.addAttribute("cargas", dao.findAll());

        return "log";
    }

    @RequestMapping(value = "/Upload" ,method = RequestMethod.GET)
    public String index(){
        return "upload";
    }

    @Autowired
    EventoDAO eventodao;


    @RequestMapping(value = "/Upload" ,method = RequestMethod.POST)
    public String UploadArq(@RequestParam String tabela, String path){
        System.out.println(path);

        switch (tabela){
            case "deputado":
                return "listdeputados";
            case "evento":
                eventodao.upload(path);
                return "index";
            default:
                return "votacoes";
        }
    }
}
