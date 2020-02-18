package com.example.crud.repository;

import com.example.crud.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // tells spring to bootstrap the repository during component scan

public interface NoteRepository extends JpaRepository<Note, Long> {
}
