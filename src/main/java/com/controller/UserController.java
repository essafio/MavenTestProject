package com.controller;

import com.beans.*;
import com.dao.UserDAO;
import com.factory.Factory;

public class UserController {

    UserDAO userDAO = Factory.getUserDAO();

    public void addUser(User user){

        userDAO.addUser(user);
    }



}
