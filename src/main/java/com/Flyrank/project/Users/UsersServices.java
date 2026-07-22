package com.Flyrank.project.Users;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class UsersServices {

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
        public UserDTO updateClient(Long id, UserDTO userDTO) {

        }

}
