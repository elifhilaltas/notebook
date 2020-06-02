package com.notebook.repository;

import com.notebook.domain.Notebook;
import org.springframework.data.repository.CrudRepository;

public interface NotebookRepository extends CrudRepository<Notebook, Long> {
}
