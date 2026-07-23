package com.Flyrank.project.Users;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
@Data
public class UsersServices {
    @Autowired
    private final PasswordEncoder encoder;
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
        client.setPassword(encoder.encode(client.getPassword()));
        client = userRepository.save(client);
        return userMapper.map(client);
    }
        public UserDTO findClientById(Long id) {
            UserModel client = userRepository.findById(id).orElse(null);
            if (client == null) {
                return null;
            }
            return userMapper.map(client);
        }

        public void deleteClientbyId(Long id) {
            userRepository.deleteById(id);
        }

        public UserDTO updateClient(@PathVariable Long id, UserDTO userDTO) {
            Optional<UserModel> userById = userRepository.findById(id);
            if (userById.isPresent()) {
                UserModel userToUpdate = userMapper.map(userDTO);
                userToUpdate.setId(id);
                userToUpdate.setPassword(encoder.encode(userToUpdate.getPassword()));
                UserModel updatedUser = userRepository.save(userToUpdate);
                return userMapper.map(updatedUser);
            }else {
                return null;
            }
        }

}
