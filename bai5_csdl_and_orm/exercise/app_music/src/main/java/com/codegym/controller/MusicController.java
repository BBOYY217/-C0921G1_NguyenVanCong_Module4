package com.codegym.controller;


import com.codegym.model.Music;
import com.codegym.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/music")
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;

    @GetMapping("")
    public String index (Model model) {
        model.addAttribute("musics", musicService.findAll());
        return "/index";
    }

    @GetMapping ("/create")
    public String create (Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/save")
    public String save (Music musicObj, RedirectAttributes redirectAttributes) {
        musicObj.setId((int) (Math.random()*10000));
        musicService.save(musicObj);
        redirectAttributes.addFlashAttribute("message", "The music was successful created.");
        return "redirect:/music";
    }

    @GetMapping ("/{id}/edit")
    public String edit (@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/edit";
    }

    @PostMapping ("/update")
    public String update (Music musicObj, RedirectAttributes redirectAttributes) {
        musicService.update(musicObj.getId(),musicObj);
        redirectAttributes.addFlashAttribute("message", "The product was successful updated.");
        return "redirect:/music";
    }

    @GetMapping ("/{id}/delete")
    public String delete (@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/delete";
    }

    @PostMapping ("/delete")
    public String delete (Music musicObj, RedirectAttributes redirectAttributes) {
        musicService.delete(musicObj.getId());
        redirectAttributes.addFlashAttribute("message", "The music was successful deleted.");
        return "redirect:/music";
    }

    @GetMapping ("/{id}/view")
    public String view (@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/view";
    }

    @GetMapping ("/search")
    public String search () {
        return "/search";
    }

    @PostMapping ("/searchByName")
    public String searchByName (Model model, @RequestParam(name = "search", required = false) String search) {
        List<Music> musicList = null;
        if (StringUtils.hasText(search)) {
            musicList = musicService.searchByName(search);
            if (!musicList.isEmpty()) {
                model.addAttribute("musics", musicList);
                model.addAttribute("message", musicList.size() + " result");
            } else {
                model.addAttribute("message", "Not found");
            }
        } else {
            musicList = musicService.findAll();
            model.addAttribute("musics", musicList);
            model.addAttribute("message", musicList.size() + " result");
        }
        return "/search";
    }
}
