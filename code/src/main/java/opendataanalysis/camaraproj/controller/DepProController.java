package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.DepProDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DepProController {

    @Autowired
    DepProDAO dao;

    @RequestMapping(value = "/Listar-DepPros", method = RequestMethod.GET)
    public String listarDepsProfissoes(Model mod){
        mod.addAttribute("depspros", dao.findAll());

        return "deputado-profissao";
    }
}
