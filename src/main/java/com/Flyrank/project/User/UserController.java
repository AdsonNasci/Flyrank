package com.Flyrank.project.User.Client;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<UserModel> all(){
        return repository.findAll();

    }
    @GetMapping("/FindId/{id}")
    public UserModel findId(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
    @GetMapping("/testing")
    public String testing(){
        return "This is my API, im so glad ur here";
    }
    @PostMapping("/add")
    public UserModel addUser(UserModel userModel) {

        return repository.save(userModel);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userModel) {
        UserModel existingUser = repository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(userModel.getName());
            existingUser.setAge(userModel.getAge());
            existingUser.setImg_url(userModel.getImg_url());
            return repository.save(existingUser);
        } else {
            return null;
        }

    }
}