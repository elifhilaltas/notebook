package com.notebook.controller;

import com.notebook.domain.Note;
import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import com.notebook.repository.UserRepository;
import com.notebook.service.NoteService;
import com.notebook.service.NotebookService;
import com.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void postUser(@RequestBody User user){
        userService.add(user);
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
    // jwt configurations
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
