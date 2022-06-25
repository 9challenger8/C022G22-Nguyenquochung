package com.validate_song.controller;


import com.validate_song.dto.SongDto;
import com.validate_song.model.Song;
import com.validate_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @RequestMapping("")
    public String displaySong(Model model){
        model.addAttribute("songs",iSongService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute @Valid SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("success","Create song successfully");
        return "redirect:/song";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute @Valid SongDto songDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "edit";
        }

        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("success","Edit song successfully");
        return "redirect:/song";

    }

    @GetMapping("/{id}/edit")
    public String editSong( @PathVariable int id, Model model){
        model.addAttribute("song", iSongService.findById(id));
        return "edit";
    }


}
