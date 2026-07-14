package com.Flyrank.project.User.Client;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class UserServices {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> listClient(){
        List<UserModel> userModels = userRepository.findAll();
        return userModels.stream()
                .map(userMapper::map)
                .toList();
    }
        public UserDTO addClient(UserDTO userDTO){
        UserModel client = UserMapper.map(userDTO);
        client = userRepository.save(client);
        return userMapper.map(client);
    }



}
