package com.boot.i_am_crud.service;

import com.boot.i_am_crud.model.User;
import com.boot.i_am_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//
//    public User getUserByFirstname(String name) {
//        return userRepository.findUserByUsername(name);
//    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(getUserByID(id));
    }

    public User getUserByID(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String a) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(a);
    }
}
