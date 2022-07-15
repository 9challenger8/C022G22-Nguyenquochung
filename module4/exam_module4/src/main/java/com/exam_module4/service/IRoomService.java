package com.exam_module4.service;

import com.exam_module4.model.Contract;
import com.exam_module4.model.Room;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoomService {
    Room findById(int id) ;

//    void removeById(int id);

    void save(Room room);

    List<Room> findAll();

    void updateToAvailable( String id);

    void updateToHired( String id);
}
