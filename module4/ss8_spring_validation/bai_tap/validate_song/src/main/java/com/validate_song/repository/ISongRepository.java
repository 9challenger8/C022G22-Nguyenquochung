package com.validate_song.repository;

import com.validate_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    @Query(value = " select * from song ",nativeQuery = true)
    List<Song> findAll();


    @Query(value = "select * from song where id= :id",nativeQuery = true)
    Song findById(@Param("id") int id);


}
