package com.example.criteria.service.impl;

import com.example.criteria.model.User;
import com.example.criteria.repository.UserRepository;
import com.example.criteria.service.UserService;
import com.example.criteria.service.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUsers(String username, Integer age) {
        Specification<User> specification = Specification.where(UserSpecification.filterByUsername(username))
                .and(UserSpecification.filterByAge(age));

        return userRepository.findAll(specification);
    }
}
