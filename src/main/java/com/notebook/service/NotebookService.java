package com.notebook.service;
import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import com.notebook.exception.BookNotFoundException;
import com.notebook.exception.InternalServerException;
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

    public Notebook getNotebookById(Long bookId){
        Optional<Notebook> optionalNotebook= notebookRepository.findById(bookId);
        try {
        return optionalNotebook.orElseThrow(() -> new BookNotFoundException("Notebook Not Found" ," Could not found Notebook with id :" + bookId ,1));

         }
        catch (InternalServerException ex) {

        return optionalNotebook.orElseThrow(() -> new InternalServerException("Internal Error", " Internal Sever Error :", 500));

        }
    }

    public void delete(Long bookId){
        notebookRepository.deleteById(bookId);
    }


     public List<Notebook>  getNotebookByUserId(Long user){
         return (List<Notebook>) notebookRepository.findByUserId(user);
     }


}
