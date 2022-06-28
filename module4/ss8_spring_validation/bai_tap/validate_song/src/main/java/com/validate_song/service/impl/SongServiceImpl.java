package com.validate_song.service.impl;


import com.validate_song.model.Song;
import com.validate_song.repository.ISongRepository;
import com.validate_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<Song> sortByName() {
        return iSongRepository.sortByName();
    }

    @Override
    public Page<Song> findAllSong(Pageable pageable) {
        return iSongRepository.findAllSong(pageable);
    }
}
