package com.notebook.repository;

import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotebookRepository extends CrudRepository<Notebook, Long> {

    List<Notebook> findByUserId(Long user);
}
