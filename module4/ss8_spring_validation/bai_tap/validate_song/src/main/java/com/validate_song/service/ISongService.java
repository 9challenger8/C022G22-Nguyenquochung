package com.validate_song.service;

import com.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    Song findById(int id);

    void save(Song song);

    List<Song> sortByName();

    Page<Song> findAllSong(Pageable pageable);

}
