package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
    String dir = "item/";

    @Value("${uploadimgdir}")
    String imgdir;

    @Autowired
    ItemService itemService;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir + "add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Item item) throws Exception {
        MultipartFile mf = item.getImg();
        String imgname = mf.getOriginalFilename();
        item.setImgname(imgname);
        itemService.register(item);//데이터를 저장하고 img파일을 우리가 사용하는 로그및이미지 디렉토리에 저장하자.
        FileUploadUtil.saveFile(mf, imgdir);
        return "redirect:/item/all";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Item> list = null;
        list = itemService.get();
        model.addAttribute("ilist",list);
        model.addAttribute("center",dir + "all");
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, Integer id) throws Exception {
        Item item = itemService.get(id);
        model.addAttribute("gitem",item);
        model.addAttribute("center",dir + "detail");
        return "index";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Item item) throws Exception {
        MultipartFile mf = item.getImg();
        String new_imgname = mf.getOriginalFilename();
        if (new_imgname.equals("")||new_imgname == null){
            itemService.modify(item);
        } else {
            item.setImgname(new_imgname);
            FileUploadUtil.saveFile(mf, imgdir);
            itemService.modify(item);
        }
        return "redirect:/item/detail?id="+item.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, Integer id) throws Exception {
        itemService.remove(id);
        return "redirect:/item/all";
    }
}
