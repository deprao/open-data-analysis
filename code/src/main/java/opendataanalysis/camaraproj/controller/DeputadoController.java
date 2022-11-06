package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.LegislaturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DeputadoController {

    DeputadoDAO dao;

    @RequestMapping(value = "/Listar-Deps", method = RequestMethod.GET)
    public String listarDeputados(Model mod){
        mod.addAttribute("deputados", dao.findAll());

        return "listdeputados";
    }
}
