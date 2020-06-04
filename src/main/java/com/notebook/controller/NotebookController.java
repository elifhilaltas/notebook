package com.notebook.controller;

import com.notebook.domain.Note;
import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import com.notebook.service.NoteService;
import com.notebook.service.NotebookService;
//import com.notebook.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
public class NotebookController {

    @Autowired
    NotebookService notebookService;

    @Autowired
    NoteService noteService;

    @GetMapping("/all")
    public String getAllNotebooks(){
        return "Hello Notebook";
    }

    @GetMapping
    public List<Notebook> getNotebooks(){
        return notebookService.getNotebooks();
    }
    @PostMapping
    public void postNotebook(@RequestBody Notebook notebook){
        notebookService.add(notebook);
    }

    @GetMapping("/{id}")
    public Notebook getById(@PathVariable(required = true) Long id){
        return notebookService.getNotebookById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) Long id){
        notebookService.delete(id);

    }
    @GetMapping("/note/{id}")
    public List<Note> getUserById(@PathVariable(required = true) Long id){
        return noteService.getNoteByNoteBookId(id);
    }



}
