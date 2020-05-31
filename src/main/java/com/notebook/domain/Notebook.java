package com.notebook.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOK_SEQ_GEN")
    @SequenceGenerator(name = "NOTEBOOK_SEQ_GEN")
    @Column(name = "BOOK_ID")
     private Long id;

    @Column(name = "NAME")
    private String name;

    // user'a bağlı notebooklar
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
