package com.exam_module4.service;

import com.exam_module4.model.Room;
import com.exam_module4.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomRepository iRoomRepository;

    @Override
    public Room findById(int id) {
        return iRoomRepository.findById(id);
    }

    @Override
    public void save(Room room) {
        iRoomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return iRoomRepository.findAll();
    }

    @Override
    public void updateToAvailable(String id) {
        iRoomRepository.updateToAvailable(id);
    }

    @Override
    public void updateToHired(String id) {
        iRoomRepository.updateToHired(id);
    }
}
