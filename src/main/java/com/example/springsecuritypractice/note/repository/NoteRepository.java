package com.example.springsecuritypractice.note.repository;

import com.example.springsecuritypractice.note.dto.Note;
import com.example.springsecuritypractice.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserOrderByIdDesc(User user);


    Note findByIdAndUser(Long id, User user);
}
