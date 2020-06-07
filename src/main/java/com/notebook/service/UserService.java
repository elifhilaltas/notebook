package com.notebook.service;

import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import com.notebook.exception.InternalServerException;
import com.notebook.exception.UserNotFoundException;
import com.notebook.repository.UserRepository;
import com.notebook.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotebookRepository notebookRepository;

    @Autowired
    NotebookService notebookService;

    private User toEntity(User user) {
        User entity = new User();
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        return entity;
    }

    public void add(User user){
        userRepository.save(toEntity(user));
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
        }

    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        try {

            return optionalUser.orElseThrow(() -> new UserNotFoundException("User Not Found", " Could not found User with id :" + userId, 1));

        } catch (InternalServerException ex) {

            return optionalUser.orElseThrow(() -> new InternalServerException("Internal Error", " Internal Sever Error :", 500));

        }
    }

    }


