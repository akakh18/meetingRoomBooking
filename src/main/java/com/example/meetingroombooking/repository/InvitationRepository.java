package com.example.meetingroombooking.repository;

import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.Room;
import com.example.meetingroombooking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findAllByGuest(User guest);

    @Transactional
    @Modifying
    @Query(value = "insert into invitations (host, guest, room) " +
            "values (:host, :guest, :room)",
            nativeQuery = true)
    void insertInvitation(@Param("host") User host, @Param("guest") User full_name,
                    @Param("room") Room room);


}
