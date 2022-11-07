package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.EventoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EventoController {

    @Autowired
    EventoDAO dao;

    @RequestMapping(value = "/Listar-Eventos", method = RequestMethod.GET)
    public String listarEventos(Model mod){
        mod.addAttribute("eventos", dao.findAll());

        return "evento";
    }



}
