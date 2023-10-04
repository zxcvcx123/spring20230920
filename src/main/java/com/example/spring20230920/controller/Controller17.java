package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto14;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main17")
public class Controller17 {

    @Autowired
    private ServletContext appllication;

    @PostConstruct
    public void init(){
        appllication.setAttribute("posts", new ArrayList<MyDto14>());
    }

    @GetMapping("list")
    public void list(Model model){
        Object list = appllication.getAttribute("posts");

        model.addAttribute("postList", list);

    }

    @GetMapping("new")
    public void newPost(){

    }

    @PostMapping ("new")
    public String newPost(MyDto14 post, RedirectAttributes rttr){
        Object posts = appllication.getAttribute("posts");
        List<MyDto14> list = (List<MyDto14>) posts;
        list.add(post);

        rttr.addFlashAttribute("message", "새 글이 등록되었습니다.");

        return "redirect:/main17/list";
    }

    @GetMapping("view")
    public String view(Integer id, Model model){
        List<MyDto14> list =  (List<MyDto14>) appllication.getAttribute("posts");

        model.addAttribute("post",list.get(id));

        return "redirect:/main17/view?id=" + id;
    }
}
