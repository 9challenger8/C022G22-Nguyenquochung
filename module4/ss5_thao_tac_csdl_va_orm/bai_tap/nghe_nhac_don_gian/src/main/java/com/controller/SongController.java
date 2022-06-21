package com.controller;


import com.model.Song;
import com.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
        private ISongService iSongService;


    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songs", iSongService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createSong(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute Song song, RedirectAttributes redirect){
        redirect.addFlashAttribute("success", "Add new successfully!");
        iSongService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String editSong(@PathVariable int id, Model model){
        model.addAttribute("song", iSongService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute Song song){
        iSongService.update( song.getId(),song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable int id, Model model){
        model.addAttribute("song", iSongService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteSong(@ModelAttribute Song song,RedirectAttributes redirect){
        redirect.addFlashAttribute("success", "Removed product successfully!");
        iSongService.remove(song.getId());
        return "redirect:/song";
    }

}
