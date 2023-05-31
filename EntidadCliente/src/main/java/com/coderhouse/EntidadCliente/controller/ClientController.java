package com.coderhouse.EntidadCliente.controller;


import com.coderhouse.EntidadCliente.middleware.ResponseHandler;
import com.coderhouse.EntidadCliente.model.Client;
import com.coderhouse.EntidadCliente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //CRUD cliente

    //Create

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Map clientFound = clientService.deleteClientById(id);
            return ResponseHandler.generateResponse(
                    "Client delete successfully",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }




    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Client client) {
        try {
            System.out.println("Antes de entrar al servicio" + client);
            Map<String, String> clientMap = new HashMap<>();//declaro e inicializo un objeto del tipo HashMap
            clientMap = clientService.postClient(client);//obtengo el objeto map
           // Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    clientMap
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage() + " o  [el formato de la fecha ingresada es incorrecto. El formato debe ser dd-MM-yyyy]",
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Map clientFound = clientService.getClientById(id);
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping
    public ResponseEntity<Object> getClientList () throws ParseException  {
        try {
          //  System.out.println(id);
            List<Map<String, String>> list = new ArrayList<>();
            list = clientService.getClientList();
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    list
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

}