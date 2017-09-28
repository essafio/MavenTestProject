package com.dao;

import com.beans.User;

import java.util.List;


public interface UserDAO {

    User addUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    void deleteUser(Long id);

    User updateUser(User user);



}
