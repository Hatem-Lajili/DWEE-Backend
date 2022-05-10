package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Exception.EntityNotFoundException;
import com.dwee.backenddwee.Models.User;
import com.dwee.backenddwee.Repository.UserRepository;
import com.dwee.backenddwee.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("cannot find user by id %s", id)
                ));
    }

    @Override
    public List<User> getAllUser() {
       return userRepository.findAll();
    }

    @Override
    public String addUser(User user) {
        return  userRepository.insert(user).getId();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
         userRepository.deleteById(id);
    }


}
