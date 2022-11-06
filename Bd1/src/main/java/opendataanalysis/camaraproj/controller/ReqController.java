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

    ReqDAO dao;

    @RequestMapping(value = "/Listar-Requerimentos", method = RequestMethod.GET)
    public String listarRequerimentos(Model mod){
        mod.addAttribute("requerimentos", dao.findAll());

        return "requerimentos";
    }
}
