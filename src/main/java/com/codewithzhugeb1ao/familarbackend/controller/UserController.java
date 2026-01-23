package com.codewithzhugeb1ao.familarbackend.controller;

import com.codewithzhugeb1ao.familarbackend.entity.User;
import com.codewithzhugeb1ao.familarbackend.exception.UserNotFoundException;
import com.codewithzhugeb1ao.familarbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User user, @PathVariable String id){
        return userRepository.findById(id)
                .map(u -> {
                    u.setUsername(user.getUsername());
                    u.setName(user.getName());
                    u.setEmail(user.getEmail());
                    return userRepository.save(u);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable String id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User with id: "+id+" deleted";
        }
        else throw new UserNotFoundException(id);
    }
}
