package com.notebook.repository;

import com.notebook.domain.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findByNotebookId(Long notebook);
    List<Note> findAllNoteByUserId(Long user);

  //  void deleteById(List<Note> noteId);
}
