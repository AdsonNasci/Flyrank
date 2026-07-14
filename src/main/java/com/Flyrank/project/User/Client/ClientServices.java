package com.Flyrank.project.User.Client;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class ClientServices {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDTO> listClient(){
        List<ClientModel> clientModels = clientRepository.findAll();
        return clientModels.stream()
                .map(clientMapper::map)
                .toList();
    }
        public ClientDTO addClient(ClientDTO clientDTO){
        ClientModel client = ClientMapper.map(clientDTO);
        client = clientRepository.save(client);
        return clientMapper.map(client);
    }



}
