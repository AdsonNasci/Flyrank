package com.Flyrank.project.User.Client;

import org.springframework.stereotype.Component;


@Component
public class ClientMapper {
    public static ClientModel map(ClientDTO clientDTO){
        ClientModel clientModel = new ClientModel();
        clientModel.setId(clientDTO.getId());
        clientModel.setName(clientDTO.getName());
        clientModel.setImg_url(clientDTO.getImg_url());
        clientModel.setAge(clientDTO.getAge());
        return clientModel;
    }
    public ClientDTO map(ClientModel clientModel){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(clientModel.getId());
        clientDTO.setName(clientModel.getName());
        clientDTO.setImg_url(clientModel.getImg_url());
        clientDTO.setAge(clientModel.getAge());
        return clientDTO;
    }
}
