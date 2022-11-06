package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.OrgaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class OrgaoController {

    OrgaoDAO dao;

    @RequestMapping(value = "/Listar-Orgaos", method = RequestMethod.GET)
    public String listarOrgaos(Model mod){
        mod.addAttribute("orgaos", dao.findAll());

        return "orgaos";
    }
}
