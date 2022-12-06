package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.DeputadoDAO;
import opendataanalysis.camaraproj.dao.DepOrgaoDAO;
import opendataanalysis.camaraproj.dao.LegislaturaDAO;
import opendataanalysis.camaraproj.models.Deputado;
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
import java.lang.Integer;

@Controller
public class DeputadoController {

    @Autowired
    DeputadoDAO dao;


    @RequestMapping(value = "/Listar-Deps", method = RequestMethod.GET)
    public String listarDeputados(Model mod){
        mod.addAttribute("deputados", dao.findAll());

        return "listdeputados";
    }

    @RequestMapping("/Deps-Name-Filter")
    public String depsNameFilterRequest(){

        return "depsnamefilter";
    }

    @RequestMapping(value = "/Listar-Deps-Filter" ,method = RequestMethod.POST)
    public String listarDeputadosFilter(Model mod,@RequestParam int value, String param) {
        switch (value){
            case 1:
                mod.addAttribute("deputados", dao.findForGenre(param));
                break;
            case 2:
                mod.addAttribute("deputados", dao.findRIPDeps());
                break;
            case 3:
                mod.addAttribute("deputados", dao.findByName(param));
        }


        return "listdeputados";
    }

    @RequestMapping(value = "/Graphs-Deps", method =  RequestMethod.POST)
    public String getDataChartsDeps(Model mod,@RequestParam int value){
        switch (value){
            case 1:
                Integer qtdMulheres = 0;
                Integer qtdHomens = 0;

                Map<String, Integer> graphData = new TreeMap<>();
                qtdHomens = dao.findQtdDepsGenre('M');
                qtdMulheres = dao.findQtdDepsGenre('F');

                graphData.put("Homens", qtdHomens);
                graphData.put("Mulheres", qtdMulheres);
                mod.addAttribute("chartData", graphData);
                return "chartdeputados";
            case 2:
                Map<String, List<Integer>> graphUF = new TreeMap<>();

                List<Integer> qtd = new ArrayList<>();
                String estados[] = {"AC", "AL", "AP","AM","BA", "CE", "ES", "GO", "MA", "MT", "MS","MG", "PA",
                        "PB", "PE", "PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO","DF"};
                int index = 0;

                for(String estado: estados){
                    qtd.add(dao.findQtdDepsUF(estado));
                }
                graphUF.put("UF", qtd);
                mod.addAttribute("chartData", graphUF);
                return "chartdeputadouf";
            case 3:
                Map<String, List<Integer>> graphDeputdosPartido = new TreeMap<>();
                Map<String, List<String>> graphPartidos = new TreeMap<>();

                List<Integer> depsPartido = new ArrayList<>();
                List<String> partidos =  new ArrayList<>();

                for(String partido:  dao.findPartidos()){
                    if(partido != null){
                        depsPartido.add(dao.findQtdPorPartido(partido));
                        partidos.add(partido);
                    }
                }
                graphDeputdosPartido.put("deputados", depsPartido);
                graphPartidos.put("partidos", partidos);
                mod.addAttribute("deputadosData", graphDeputdosPartido);
                mod.addAttribute("partidosData", graphPartidos);

                return  "chartdeputadospartido";
            case 4:
                Map<String, List<Integer>> graphDeputdosProf = new TreeMap<>();
                Map<String, List<String>> graphProfs = new TreeMap<>();

                List<Integer> depsProfs = new ArrayList<>();
                List<String> profs =  new ArrayList<>();

                for(String prof:  dao.findProfissoes()){
                    if(prof != null){
                        depsProfs.add(dao.findQtdPorProfissao(prof));
                        profs.add(prof);
                    }
                }
                graphDeputdosProf.put("deputados", depsProfs);
                graphProfs.put("profissoes", profs);
                mod.addAttribute("deputadosData", graphDeputdosProf);
                mod.addAttribute("profissoesData", graphProfs);

                return  "chartdeputadosprof";


        }

        return "index";
    }

}
