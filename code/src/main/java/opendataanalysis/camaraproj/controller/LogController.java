package opendataanalysis.camaraproj.controller;

import opendataanalysis.camaraproj.dao.UploadLogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LogController {

    @Autowired
    UploadLogDAO dao;

    @RequestMapping(value = "/Historico-Uploads", method = RequestMethod.GET)
    public String listarUploads(Model mod){
        mod.addAttribute("uploads",dao.findAll());

        return "uploads";
    }
}
