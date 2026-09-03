package com.AndreyApp.project.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class UserController {

    private final UsersServices usersServices;

    public UserController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> listAll(){
        List<UserDTO> users = usersServices.listClient();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/FindId/{id}")
    public ResponseEntity<?> findId(@PathVariable Long id){
        UserDTO user = usersServices.findClientById(id);
        if(user != null){
            return  ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not founded"+ id);
        }
    }
    @GetMapping("/testing")
    public String testing(){
        return "This is my API, im so glad ur here";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        UserDTO newUser = usersServices.addClient(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully : " + newUser.getName());

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if(usersServices.findClientById(id) != null){
            usersServices.deleteClientbyId(id);
            return ResponseEntity.ok("User deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found"+ id);
        }
    }
    @PutMapping("/update/{id}")  
    public ResponseEntity<String> updateUser(Long id, @RequestBody UserDTO userUpdated) {
        if(usersServices.findClientById(id) != null){
            UserDTO newUser = usersServices.updateClient(id,userUpdated);
            return ResponseEntity.ok("User updated successfully" + newUser.toString());
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }
    }
}