package com.validate_song.service;

import com.validate_song.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    Song findById(int id);

    void save(Song song);

}
