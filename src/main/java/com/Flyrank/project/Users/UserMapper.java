package com.Flyrank.project.Users;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public static UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setLogin(userDTO.getLogin());
        userModel.setEmail(userDTO.getEmail());
        userModel.setName(userDTO.getName());
        userModel.setImgUrl(userDTO.getImgUrl());
        userModel.setPassword(userDTO.getPassword());

        return userModel;
    }
    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setLogin(userModel.getLogin());
        userDTO.setName(userModel.getName());
        userDTO.setImgUrl(userModel.getImgUrl());
        userDTO.setPassword(userModel.getPassword());
        userDTO.setEmail(userModel.getEmail());

        return userDTO;
    }
}
