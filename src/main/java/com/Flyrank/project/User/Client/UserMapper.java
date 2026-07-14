package com.Flyrank.project.User.Client;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public static UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setImg_url(userDTO.getImg_url());
        userModel.setAge(userDTO.getAge());
        return userModel;
    }
    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setImg_url(userModel.getImg_url());
        userDTO.setAge(userModel.getAge());
        return userDTO;
    }
}
