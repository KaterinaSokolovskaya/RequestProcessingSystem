package com.sokolovskaya.task.service.service;

import com.sokolovskaya.task.database.repository.UserRepository;
import com.sokolovskaya.task.service.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    public User getByName(String name) {
        return userRepository.findByName(name)
                .map(it -> new User(it.getId(), it.getName(), it.getRole()))
                .orElse(new User());
    }
}
