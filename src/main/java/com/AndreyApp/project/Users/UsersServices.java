package com.AndreyApp.project.Users;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Data
public class UsersServices {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @ApiResponse(responseCode = "200", description = "List of all clients")

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
