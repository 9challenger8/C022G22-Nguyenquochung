package com.exam_module4.repository;

import com.exam_module4.model.Contract;
import com.exam_module4.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IRoomRepository extends JpaRepository<Room,Integer> {

    @Query(value = "select * from room where status = 'available'",nativeQuery = true)
    List<Room> findAll();

    @Query(value = "select * from room where id = :id and status = available ", nativeQuery = true)
    Room findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update room set status = 'available' where id = :id", nativeQuery = true)
    void updateToAvailable(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "update room set status = 'hired' where id = :id", nativeQuery = true)
    void updateToHired(@Param("id") String id);

}
