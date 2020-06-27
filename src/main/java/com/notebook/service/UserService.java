package com.notebook.service;

import com.notebook.domain.User;
import com.notebook.exception.UserNotFoundException;
import com.notebook.repository.NotebookRepository;
import com.notebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User getUserById(Long userId)  throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseThrow(() ->new  UserNotFoundException("User Not Found", " Could not found User with id :" + userId, 1));

         }

    }


