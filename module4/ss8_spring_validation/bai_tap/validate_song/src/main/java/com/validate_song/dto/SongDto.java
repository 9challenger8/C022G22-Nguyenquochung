package com.validate_song.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {

    private Integer id;

    @NotEmpty
    @Size(max=800,message = "Length is max 800")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "khong chua ki tu dac biet")
    private String name;

    @NotEmpty
    @Size(max=300,message = "Length is max 300")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "khong chua ki tu dac biet")
    private String artist;

    @NotEmpty
    @Size(max=1000,message = "Length is max 1000")
    @Pattern(regexp = "^[a-zA-Z0-9\\,]*$",message = "khong chua ki tu dac biet tru dau phay")
    private String typeMusic;


    public SongDto() {
    }

    public SongDto(Integer id, String name, String artist, String typeMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.typeMusic = typeMusic;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

}
