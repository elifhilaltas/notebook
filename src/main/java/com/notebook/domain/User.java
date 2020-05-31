package com.notebook.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTEBOOK_SEQ_GEN")
    @SequenceGenerator(name = "NOTEBOOK_SEQ_GEN")
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private  String lastName;

  //  @OneToMany(mappedBy = "userId")
 //   @Column(name = "NOTEBOOK_ID")
  //  private List<Notebook> notebookId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
