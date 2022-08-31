package br.com.torugo.fullstackbackend.controller;

import br.com.torugo.fullstackbackend.model.User;
import br.com.torugo.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id){
        return userRepository.findById(id);
    }


}
