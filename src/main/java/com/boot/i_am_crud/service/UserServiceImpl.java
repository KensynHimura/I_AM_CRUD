package com.boot.i_am_crud.service;

import com.boot.i_am_crud.model.User;
import com.boot.i_am_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(getUserByID(id));
    }

    @Transactional
    public User getUserByID(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String a) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(a);
    }
}
