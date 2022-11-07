package opendataanalysis.camaraproj.controller;

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
public class LegislaturaController {

    @Autowired
    LegislaturaDAO dao;

    @RequestMapping(value = "/Listar-Leg", method = RequestMethod.GET)
    public String listarLegislaturas(Model mod){
        mod.addAttribute("legislaturas", dao.findAll());

        return "legislatura";
    }
}
