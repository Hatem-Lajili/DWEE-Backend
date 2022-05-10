package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getAllUser();

    String addUser(User user);

    User updateUser(User user);

    void deleteUser (String id);
}
