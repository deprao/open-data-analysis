package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.DepOcupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DepOcupController {

    DepOcupDAO dao;

    @RequestMapping(value = "/Listar-DepOcups", method = RequestMethod.GET)
    public String listarDepsOcupacoes(Model mod){
        mod.addAttribute("depsocups", dao.findAll());

        return "depsocups";
    }
}
