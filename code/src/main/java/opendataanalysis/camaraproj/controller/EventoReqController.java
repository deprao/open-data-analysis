package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.EventoReqDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EventoReqController {

    @Autowired
    EventoReqDAO dao;

    @RequestMapping(value = "/Listar-RequerimentosEventos", method = RequestMethod.GET)
    public String listarRequerimentosDeEventos(Model mod){
        mod.addAttribute("eventsreqs", dao.findAll());

        return "eveto-requerimento";
    }
}
