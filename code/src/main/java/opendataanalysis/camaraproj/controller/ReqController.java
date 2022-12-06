package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.ReqDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ReqController {

    @Autowired
    ReqDAO dao;

    @RequestMapping(value = "/Listar-Requerimentos", method = RequestMethod.GET)
    public String listarRequerimentos(Model mod){
        mod.addAttribute("requerimentos", dao.findAll());

        return "requerimentos";
    }

    @RequestMapping(value = "/Listar-Req-Filter" ,method = RequestMethod.POST)
    public String listarDeputadosFilter(Model mod,@RequestParam int value, String param) {
        switch (value){
            case 1:
                mod.addAttribute("requerimentos", dao.findByName(param));
                return "requerimentos";
        }


        return "index";
    }
}
