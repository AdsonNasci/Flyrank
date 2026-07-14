package com.Flyrank.project.User.Client;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ClientController {

    private ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<ClientModel> all(){
        return repository.findAll();

    }
    @GetMapping("/FindId/{id}")
    public ClientModel findId(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }
    @GetMapping("/testing")
    public String testing(){
        return "This is my API, im so glad ur here";
    }
    @PostMapping("/add")
    public ClientModel addUser(ClientModel clientModel) {

        return repository.save(clientModel);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ClientModel updateUser(@PathVariable Long id, @RequestBody ClientModel clientModel) {
        ClientModel existingUser = repository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(clientModel.getName());
            existingUser.setAge(clientModel.getAge());
            existingUser.setImg_url(clientModel.getImg_url());
            return repository.save(existingUser);
        } else {
            return null;
        }

    }
}