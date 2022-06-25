package com.validate_song.service.impl;


import com.validate_song.model.Song;
import com.validate_song.repository.ISongRepository;
import com.validate_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }
}
