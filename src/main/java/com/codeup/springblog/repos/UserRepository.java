package com.codeup.springblog.repos;

import com.codeup.springblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}