package com.notebook.service;


import com.notebook.domain.Note;
import com.notebook.exception.NoteNotFoundException;
import com.notebook.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    private Note toEntity(Note note) {
        Note entity = new Note();
        entity.setUser(note.getUser());
        entity.setName(note.getName());
        entity.setText(note.getText());
        entity.setNotebook(note.getNotebook());
        return entity;
    }

    public void add(Note note){
        noteRepository.save(toEntity(note));

    }

    public  List<Note> getNotes(){
        return (List<Note>) noteRepository.findAll();
    }

    public Note getNoteById(Long noteId){
        Optional<Note> optionalNote= noteRepository.findById(noteId);

            return optionalNote.orElseThrow(() -> new NoteNotFoundException("Note Not Found" ," Could not found Note with id :" + noteId ,1));

    }
    public void delete(Long noteId){
        noteRepository.deleteById(noteId);
    }


    public List<Note> getNoteByNoteBookId(Long book){
        return (List<Note>) noteRepository.findByNotebookId(book);
    }

    public List<Note> findUsersAllNoteById(Long user){
        return (List<Note>) noteRepository.findAllNoteByUserId(user);
    }

}
