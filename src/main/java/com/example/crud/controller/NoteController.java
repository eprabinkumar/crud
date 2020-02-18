package com.example.crud.controller;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Note;
import com.example.crud.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController     //annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
                    //The @Controller annotation is used to define a controller and the
                    //@ResponseBody annotation is used to indicate that the return value of a method
                    // should be used as the response body of the request.

@RequestMapping("/api") //declares that the url for all the apis in this controller will start with /api

public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    // Get All Notes
    @GetMapping("/notes")  //annotation is a short form of @RequestMapping(value="/notes", method=RequestMethod.GET)
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/notes")  // annotation is for post method
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }
    //@RequestBody is used to bind the request body with the model parameter
    //@Valid used to make sure the request body is valid
    // if the request body doesn't have a title or content, then spring will return 400 BadRequest message to client

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }
    //@PathVariable used to bind path variable with the method parameter

    // Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updateNote = noteRepository.save(note);
        return updateNote;
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
