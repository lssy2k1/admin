package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {
    String dir = "cust/";

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    CustService custService;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir + "add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Cust> list = null;
        list = custService.get();
        model.addAttribute("clist", list);
        model.addAttribute("center",dir + "all");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, @Validated Cust cust, Errors errors) throws Exception {
        if(errors.hasErrors()){
            List<ObjectError> es = errors.getAllErrors();
            String msg = "";
            for(ObjectError e:es){
                msg += "<h4>";
                msg += e.getDefaultMessage();
                msg += "</h4>";
            }
            throw new Exception(msg);
        }
        cust.setPwd(encoder.encode(cust.getPwd()));
        custService.register(cust);
        return "redirect:/cust/all";
//        model.addAttribute("center", dir+"add");
//        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, String id) throws Exception {
        Cust cust = null;
        cust = custService.get(id);
        model.addAttribute("dcust", cust);
        model.addAttribute("center",dir + "detail");
        return "index";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, @Validated Cust cust, Errors errors) throws Exception {
        if(errors.hasErrors()){
            List<ObjectError> es = errors.getAllErrors();
            String msg = "";
            for(ObjectError e:es){
                msg += "<h4>";
                msg += e.getDefaultMessage();
                msg += "</h4>";
            }
            throw new Exception(msg);
        }
        cust.setPwd(encoder.encode(cust.getPwd()));
        custService.modify(cust);
        return "redirect:/cust/detail?id="+cust.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, String id) throws Exception {
        custService.remove(id);
//        model.addAttribute("center",dir + "all");
//        return "index";
        return "redirect:/cust/all";
    }
}