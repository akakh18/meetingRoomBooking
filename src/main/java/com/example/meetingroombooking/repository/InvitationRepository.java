package com.example.meetingroombooking.repository;

import com.example.meetingroombooking.model.entity.Invitation;
import com.example.meetingroombooking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findAllByGuest(User guest);
}
