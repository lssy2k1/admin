package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tables")
public class ItemController {
    @RequestMapping("")
    public String main(Model model){
        List<Item> list = new ArrayList<>();
        list.add(new Item(100,"pasta1",1001,"a.jpg", new Date()));
        list.add(new Item(101,"pasta2",1002,"a.jpg", new Date()));
        list.add(new Item(102,"pasta3",1003,"a.jpg", new Date()));
        list.add(new Item(103,"pasta4",1004,"a.jpg", new Date()));
        list.add(new Item(104,"pasta5",1005,"a.jpg", new Date()));
        list.add(new Item(105,"pasta6",1006,"a.jpg", new Date()));
        list.add(new Item(106,"pasta7",1007,"a.jpg", new Date()));
        list.add(new Item(107,"pasta8",1008,"a.jpg", new Date()));
        list.add(new Item(108,"pasta9",1009,"a.jpg", new Date()));
        list.add(new Item(109,"pasta0",10010,"a.jpg", new Date()));
        list.add(new Item(111,"pasta11",10020,"a.jpg", new Date()));
        list.add(new Item(112,"pasta12",10030,"a.jpg", new Date()));
        list.add(new Item(113,"pasta13",10040,"a.jpg", new Date()));
        list.add(new Item(114,"pasta14",10050,"a.jpg", new Date()));
        list.add(new Item(115,"pasta15",10060,"a.jpg", new Date()));
        list.add(new Item(116,"pasta16",10070,"a.jpg", new Date()));
        model.addAttribute("itemlist", list);
        model.addAttribute("center", "tables");
        return "index";
    }

}
