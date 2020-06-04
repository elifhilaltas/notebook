package com.notebook.controller;

import com.notebook.domain.Note;
import com.notebook.domain.Notebook;
import com.notebook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping
    public List<Note> getNotes(){
        return noteService.getNotes();
    }
    @PostMapping
    public void postNote(@RequestBody Note note){
        noteService.add(note);
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable(required = true) Long id){
        return noteService.getNoteById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) Long id){
        noteService.delete(id);

    }

}
