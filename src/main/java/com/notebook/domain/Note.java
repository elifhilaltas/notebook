package com.notebook.domain;

import javax.persistence.*;

@Entity
@Table(name = "NOTE")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOK_SEQ_GEN")
    @SequenceGenerator(name = "NOTEBOOK_SEQ_GEN")
    @Column(name = "NOTE_ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID")
    private Notebook notebook;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEXT")
    private String text;

    // user'a bağlı notelar
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
