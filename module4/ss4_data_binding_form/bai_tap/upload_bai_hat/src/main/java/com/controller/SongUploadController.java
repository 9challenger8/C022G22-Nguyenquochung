package com.controller;


import com.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongUploadController {
    @GetMapping("/display")
    public String show(Model model){
        model.addAttribute("song",new Song());
        return "song_information";
    }

    @PostMapping("/display")
    public String music(@ModelAttribute Song song , Model model){
        model.addAttribute("songResult",song);
        return "song_information";
    }
}
