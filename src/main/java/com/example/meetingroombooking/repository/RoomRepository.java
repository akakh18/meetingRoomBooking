package com.example.meetingroombooking.repository;

import com.example.meetingroombooking.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room getRoomById(Long id);
}
