package com.coderhouse.EntidadCliente.service;

import com.coderhouse.EntidadCliente.model.Client;
import com.coderhouse.EntidadCliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Map postClient(Client clientSaved) throws Exception {
        //Evaluo si el formato de la fecha es el correcto
        String pattern = "dd-MM-yyyy";//caro un formato de fecha a un string
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(pattern);//declaro e inicializo una variable del tipo DateTimeFormatter
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);//declaro e inicializo una variable del tipo SimpleDateFormat
        String dateString = dateFormat.format(clientSaved.getYearbirth());//obtengo la fecha del tipo date y la convierto en fecha del tipo string con formato
        LocalDate fecha  = LocalDate.parse(dateString, formato);//intento parsear la decha obtenida a local date, si lo parsea ok, sigue avanzando con la ejecucion de codigo, si no, sale por error en el controller


        Map<String, String> map = new LinkedHashMap<>();
        map.put("Name", clientSaved.getName());
        map.put("LastName", clientSaved.getLastname());
        map.put("DocNumber", clientSaved.getDocnumber());
        Date dateBirth = clientSaved.getYearbirth();

        Date fechaActual = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(dateBirth));
        int d2 = Integer.parseInt(formatter.format(fechaActual));
        int age = ((d2 - d1) / 10000);
        map.put("Yearbirth", dateString);
        map.put("Años", Integer.toString(age));

        clientRepository.save(clientSaved);

        return map;
    }

    public Map getClientById(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);//obtengo el cliente por id
        Map<String, String> clietnMap = new LinkedHashMap<>();//genero un objeto del tipo LinkedHashMap
        if(client.isEmpty()){// si el cliente es null devuelvo null
            return null;
        } else {
            Client clientFound = client.get();//declaro e inicializo un objeto del tipo client
            //Evaluo si el formato de la fecha es el correcto
            String pattern = "dd-MM-yyyy";//caro un formato de fecha a un string
            DateTimeFormatter formato = DateTimeFormatter.ofPattern(pattern);//declaro e inicializo una variable del tipo DateTimeFormatter
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);//declaro e inicializo una variable del tipo SimpleDateFormat
            String dateString = dateFormat.format(clientFound.getYearbirth());//obtengo la fecha del tipo date y la convierto en fecha del tipo string con formato
            LocalDate fecha  = LocalDate.parse(dateString, formato);//intento parsear la decha obtenida a local date, si lo parsea ok, sigue avanzando con la ejecucion de codigo, si no, sale por error en el controller



            clietnMap.put("Name", clientFound.getName());//obntego el nombre del cliente para cargarlo en el map
            clietnMap.put("LasteNAme", clientFound.getLastname());//obntego el apellido del cliente para cargarlo en el map
            clietnMap.put("DocNumber", clientFound.getDocnumber());//obntego el apellido del cliente para cargarlo en el map

            Map<String, String> map = new LinkedHashMap<>();
            map.put("Name", clientFound.getName());
            map.put("LastName", clientFound.getLastname());
            map.put("DocNumber", clientFound.getDocnumber());
            Date dateBirth = clientFound.getYearbirth();

            Date fechaActual = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            int d1 = Integer.parseInt(formatter.format(dateBirth));
            int d2 = Integer.parseInt(formatter.format(fechaActual));
            int age = ((d2 - d1) / 10000);
            clietnMap.put("Yearbirth", dateString);
            clietnMap.put("YearOld", Integer.toString(age));

            //clientRepository.save(clientFound);

            return clietnMap;
        }
    }

    public List<Map<String, String>> getClientList() throws ParseException {

        List<Client> clientList = clientRepository.findAll();
        List<Map<String, String>> clientListOfMaps = new ArrayList<>();
        if(clientList.isEmpty()){
            return null;
        } else {
            //Evaluo si el formato de la fecha es el correcto
            String pattern = "dd-MM-yyyy";//caro un formato de fecha a un string
            DateTimeFormatter formato = DateTimeFormatter.ofPattern(pattern);//declaro e inicializo una variable del tipo DateTimeFormatter
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);//declaro e inicializo una variable del tipo SimpleDateFormat
            for (Client client : clientList) {//recorro cada elemento de la lista y proceso sus datos tal cual metodo getClient pero a lo ultimo lo cargo en una lista

                String dateString = dateFormat.format(client.getYearbirth());//obtengo la fecha del tipo date y la convierto en fecha del tipo string con formato
                LocalDate fecha  = LocalDate.parse(dateString, formato);//intento parsear la decha obtenida a local date, si lo parsea ok, sigue avanzando con la ejecucion de codigo, si no, sale por error en el controller

                Map<String, String> clientMap = new LinkedHashMap<>();//genero un objeto del tipo LinkedHashMap
                clientMap.put("Name", client.getName());//obntego el nombre del cliente para cargarlo en el map
                clientMap.put("LasteNAme", client.getLastname());//obntego el apellido del cliente para cargarlo en el map
                clientMap.put("DocNumber", client.getDocnumber());//obntego el apellido del cliente para cargarlo en el map

                Date dateBirth = client.getYearbirth();
                Date fechaActual = new Date();
                DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                int d1 = Integer.parseInt(formatter.format(dateBirth));
                int d2 = Integer.parseInt(formatter.format(fechaActual));
                int age = ((d2 - d1) / 10000);
                clientMap.put("Yearbirth", dateString);
                clientMap.put("YearOld", Integer.toString(age));
                clientListOfMaps.add(clientMap);
            }
            return clientListOfMaps;
        }
    }


    public Map deleteClientById(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);//obtengo el cliente por id
        Map<String, String> clietnMap = new LinkedHashMap<>();//genero un objeto del tipo LinkedHashMap
        if(client.isEmpty()){// si el cliente es null devuelvo null
            return null;
        } else {
            Client clientFound = client.get();//declaro e inicializo un objeto del tipo client
            //Evaluo si el formato de la fecha es el correcto
            String pattern = "dd-MM-yyyy";//caro un formato de fecha a un string
            DateTimeFormatter formato = DateTimeFormatter.ofPattern(pattern);//declaro e inicializo una variable del tipo DateTimeFormatter
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);//declaro e inicializo una variable del tipo SimpleDateFormat
            String dateString = dateFormat.format(clientFound.getYearbirth());//obtengo la fecha del tipo date y la convierto en fecha del tipo string con formato
            LocalDate fecha  = LocalDate.parse(dateString, formato);//intento parsear la decha obtenida a local date, si lo parsea ok, sigue avanzando con la ejecucion de codigo, si no, sale por error en el controller



            clietnMap.put("Name", clientFound.getName());//obntego el nombre del cliente para cargarlo en el map
            clietnMap.put("LasteNAme", clientFound.getLastname());//obntego el apellido del cliente para cargarlo en el map
            clietnMap.put("DocNumber", clientFound.getDocnumber());//obntego el apellido del cliente para cargarlo en el map

            Map<String, String> map = new LinkedHashMap<>();
            map.put("Name", clientFound.getName());
            map.put("LastName", clientFound.getLastname());
            map.put("DocNumber", clientFound.getDocnumber());
            Date dateBirth = clientFound.getYearbirth();

            Date fechaActual = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            int d1 = Integer.parseInt(formatter.format(dateBirth));
            int d2 = Integer.parseInt(formatter.format(fechaActual));
            int age = ((d2 - d1) / 10000);
            clietnMap.put("Yearbirth", dateString);
            clietnMap.put("YearOld", Integer.toString(age));

            clientRepository.delete(clientFound);

            return clietnMap;
        }
    }




}

