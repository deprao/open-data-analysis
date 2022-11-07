package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.VotacaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class VotacaoController {

    @Autowired
    VotacaoDAO dao;

    @RequestMapping(value = "/Listar-Votacoes", method = RequestMethod.GET)
    public String listarVotacoes(Model mod){
        mod.addAttribute("votacoes", dao.findAll());

        return "votacoes";
    }
}
