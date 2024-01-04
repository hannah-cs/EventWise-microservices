package com.example.controller;

import com.example.model.Client;
import com.example.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id") Integer id){
        return clientService.getClient(id);
    }

    @PostMapping
    public void createClient(@RequestBody Client newClient){
        clientService.createClient(newClient);
    }
}
