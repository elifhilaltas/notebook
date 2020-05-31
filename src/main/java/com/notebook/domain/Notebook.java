package com.notebook.domain;

import javax.persistence.*;

@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOK_SEQ_GEN")
    @SequenceGenerator(name = "NOTEBOOK_SEQ_GEN")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USER_ID")
    private String userId;


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
        name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
