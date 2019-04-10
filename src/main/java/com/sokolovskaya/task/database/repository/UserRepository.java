package com.sokolovskaya.task.database.repository;

import com.sokolovskaya.task.database.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findById(Integer id);

    Optional<User> findByName(String name);
}
