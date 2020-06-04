package com.notebook.service;
import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import com.notebook.exception.BookNotFoundException;
import com.notebook.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class NotebookService {
    @Autowired
    NotebookRepository notebookRepository;

    private Notebook toEntity(Notebook notebook) {
        Notebook entity = new Notebook();
        entity.setName(notebook.getName());
        entity.setUser(notebook.getUser());
        return entity;
    }

    public void add(Notebook notebook){
        notebookRepository.save(toEntity(notebook));

    }

    public  List<Notebook> getNotebooks(){
        return (List<Notebook>) notebookRepository.findAll();
    }

    public Notebook getNotebookById(Long id){
        Optional<Notebook> optionalNotebook= notebookRepository.findById(id);
        return optionalNotebook.orElseThrow(() -> new BookNotFoundException("Book not found"));

    }
    public void delete(Long id){
        notebookRepository.deleteById(id);
    }


     public List<Notebook>  getNotebookByUserId(Long user){
         return (List<Notebook>) notebookRepository.findByUserId(user);
     }


}
