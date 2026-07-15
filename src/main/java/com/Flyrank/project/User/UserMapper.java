package com.Flyrank.project.User;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public static UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setImgUrl(userDTO.getImg_url());
        userModel.setAge(userDTO.getAge());
        return userModel;
    }
    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setImg_url(userModel.getImgUrl());
        userDTO.setAge(userModel.getAge());
        return userDTO;
    }
}
