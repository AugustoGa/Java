package edu.coderhouse.ClientApiRest.controller;

import edu.coderhouse.ClientApiRest.middleware.ResponseHandler;
import edu.coderhouse.ClientApiRest.model.Client;
import edu.coderhouse.ClientApiRest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //CRUD cliente

    //Create
    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Client client) {
        try {
            System.out.println(client);
            Map<String, String> clientMap = new HashMap<>();//declaro e inicializo un objeto del tipo HashMap
            clientMap = clientService.postClient(client);//obtengo el objeto map
            return ResponseHandler.generateResponse(
                    "El cliente se cargo correctamente",
                    HttpStatus.OK,
                    clientMap

            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage() + " o  [el formato de la fecha ingresada es incorrecto. El formato debe ser yyyy-MM-dd]",
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Map<String, String> clientMapFound = new HashMap<>();//declaro e inicializo un objeto del tipo HashMap
             clientMapFound = clientService.getClient(id);//obtengo el objeto map
            return ResponseHandler.generateResponse(
                    "Client get successfully",
                    HttpStatus.OK,
                    clientMapFound
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
