package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.OrgaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class OrgaoController {

    @Autowired
    OrgaoDAO dao;

    @RequestMapping(value = "/Listar-Orgaos", method = RequestMethod.GET)
    public String listarOrgaos(Model mod){
        mod.addAttribute("orgaos", dao.findAll());

        return "orgao";
    }

    @RequestMapping(value = "/Graphs-Orgao", method =  RequestMethod.POST)
    public String getDataChartsDeps(Model mod,@RequestParam int value){
        switch (value){
            case 1:
                Map<String, List<Integer>> graphEventosPorOrgao = new TreeMap<>();
                Map<String, List<String>> graphOrgaos = new TreeMap<>();

                List<Integer> eventosPOrgs = new ArrayList<>();
                List<String> orgaos =  new ArrayList<>();

                for(Integer orgaoID:  dao.findOrgaosEventos()){
                    orgaos.add(dao.findOrgaosById(orgaoID));
                    eventosPOrgs.add(dao.findQtdEveByOrg(orgaoID));
                }
                graphOrgaos.put("orgaos", orgaos);
                graphEventosPorOrgao.put("eventos", eventosPOrgs);
                mod.addAttribute("eventosData", graphEventosPorOrgao);
                mod.addAttribute("orgaosData", graphOrgaos);

                return  "chartevepororg";
        }

        return "index";
    }
}
