package com.notebook.repository;

import com.notebook.domain.Notebook;
import com.notebook.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
