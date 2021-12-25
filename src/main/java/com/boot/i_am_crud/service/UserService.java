package com.boot.i_am_crud.service;

import com.boot.i_am_crud.model.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    public void saveOrUpdateUser(User user);

    public void deleteUser(Long id);

    public User getUserByID(Long id);
}
