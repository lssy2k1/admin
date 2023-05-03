package com.kbstar.controller;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    AdmService admService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/charts")
    public String charts(Model model) {
        model.addAttribute("center", "charts");
        return "index";
    }

    @RequestMapping("/livechart")
    public String livechart(Model model) {
        model.addAttribute("center", "livechart");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        Adm adm = null;
        String nextpage = "loginfail";
        try {
            adm = admService.get(id);

            if (adm != null && encoder.matches(pwd, adm.getPwd())) {
                nextpage = "loginok";
                session.setMaxInactiveInterval(100000);
                session.setAttribute("loginadm", adm);
            }
        } catch (Exception e) {
            throw new Exception("loginimpl error");
        }

        model.addAttribute("center", nextpage);
        return "index";
    }
    @RequestMapping("/logoutimpl")
    public String logoutimpl(Model model, HttpSession session){
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Adm adm, HttpSession session) throws Exception {
        adm.setPwd(encoder.encode(adm.getPwd()));
        try {
            admService.register(adm);
            session.setMaxInactiveInterval(100000);
            session.setAttribute("loginadm", adm);
        } catch (Exception e) {
            throw new Exception("registerimpl error!");
        }
        model.addAttribute("radm", adm);
        //model.addAttribute("center", "registerok");
        return "redirect:/";
    }


}
