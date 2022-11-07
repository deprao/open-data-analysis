package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.DepOrgaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DepOrgaoController {

    @Autowired
    DepOrgaoDAO dao;

    @RequestMapping(value = "/Listar-DepsPorOrgs", method = RequestMethod.GET)
    public String listarDeputadosPorOrgaos(Model mod){
        mod.addAttribute("depsorgs", dao.findAll());

        return "deputado-orgao";
    }

}
