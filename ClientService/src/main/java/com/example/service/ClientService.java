package com.example.service;

import com.example.model.Client;
import com.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClient(Integer id){
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    public void createClient(Client newClient){
        clientRepository.save(newClient);
    }
}
