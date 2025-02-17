package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.EventoPresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EventoPresencaController {

    @Autowired
    EventoPresDAO dao;

    @RequestMapping(value = "/Listar-PresencasEventos", method = RequestMethod.GET)
    public String listarDeputadosEmEventos(Model mod){
        mod.addAttribute("depspresens", dao.findAll());

        return "evento-presenca";
    }
}
