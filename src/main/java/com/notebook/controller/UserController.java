package com.notebook.controller;

import com.notebook.domain.Note;
import com.notebook.domain.User;
import com.notebook.domain.Notebook;
import com.notebook.service.NoteService;
import com.notebook.service.NotebookService;
import com.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    NotebookService notebookService;

    @Autowired
    NoteService noteService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public void postUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        userService.add(user);
        response.getWriter().println("Added new user");
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(required = true) Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) Long id){
        userService.delete(id);

    }
    @GetMapping("/notebook/{id}")
    public List<Notebook> getNotebookByUserId(@PathVariable(required = true) Long id){
       return notebookService.getNotebookByUserId(id);
    }

    @GetMapping("/note/{id}")
    public List<Note> getAllNoteByUserId(@PathVariable(required = true) Long id){
        return noteService.findUsersAllNoteById(id);
    }

}
