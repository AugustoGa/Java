package edu.coderhouse.ClientApiRest.service;

import edu.coderhouse.ClientApiRest.model.Client;
import edu.coderhouse.ClientApiRest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.LinkedHashMap;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Map postClient(Client clientSaved) throws Exception {
            //Evaluo si el formato de la fecha es el correcto
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");//inicializo un formato de fecha
            LocalDate fecha  = LocalDate.parse(clientSaved.getFechaNacimiento(), formato);//va aintentar parsear al fecha de nacimiento, en caso de que no pueda se va a generar un error
            //que sera atrapado por el clientControl informando error 500

            //Genero un objeto del tipo LinkedHashMap por sera necesario a la hora de mostrarlo como response luego de que el post salga exitoso
            Map<String, String> map = new LinkedHashMap<>();//inicializo un LinkedHashMap por que a diferencia del HashMap, este se carga los elementos de manera ordenada por orden  de carga

            map.put("Nombre", clientSaved.getNombre());//obntego el nombre del cliente para cargarlo en el map
            map.put("Apellido", clientSaved.getApellido());//obntego el apellido del cliente para cargarlo en el map

            String fechaNacimiento = clientSaved.getFechaNacimiento();//obntego el la fecha de nacimiento del cliente para cargarlo en un string
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//inicializo un objeto del tipo SimpleDateFormat con el formato yyyy-MM-dd
            Date fechaNAcimientoDate = dateFormat.parse(fechaNacimiento);//tomo la fecha que esta como string y la parseo a date
            Date fechaActual = new Date();//tomo la fecha actual como punto de referencia para luego hacer el calculo en años
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");//inicializo un objeto SimpleDateFormat con un formato con el que podra hacer resta entre fechas y asi calcular los años del cleinte
            int d1 = Integer.parseInt(formatter.format(fechaNAcimientoDate));//parseo la fecha de nacimiento del cliente a integer
            int d2 = Integer.parseInt(formatter.format(fechaActual));//parseo la fecha actual a integer
            int age = ((d2 - d1) / 10000);//realizo la resota y divicios correspondiente para obtener la cantidad de años del cliente
            map.put("Años", Integer.toString(age));//cargo al map los años del cleinte

            clientRepository.save(clientSaved);//esto impacta el cliente cargado por request a la base

        return map;
    }

    public Map getClient(int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById(id);//obtengo el cliente por id
        Map<String, String> clietnMap = new LinkedHashMap<>();//genero un objeto del tipo LinkedHashMap


        if(cliente.isEmpty()){// si el cliente es null devuelvo null
            return null;
        } else {
            Client clientFound = cliente.get();//declaro e inicializo un objeto del tipo client

            //Evaluo si el formato de la fecha que de me devuelve la base es el correcto
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");//inicializo un formato de fecha
            LocalDate fecha  = LocalDate.parse(clientFound.getFechaNacimiento(), formato);//va aintentar parsear al fecha de nacimiento, en caso de que no pueda se va a generar un error
            //que sera atrapado por el clientControl informando error 500

            clietnMap.put("Nombre", clientFound.getNombre());//obntego el nombre del cliente para cargarlo en el map
            clietnMap.put("Apellido", clientFound.getApellido());//obntego el apellido del cliente para cargarlo en el map

            String fechaNacimiento = clientFound.getFechaNacimiento();//obntego el la fecha de nacimiento del cliente para cargarlo en un string
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//inicializo un objeto del tipo SimpleDateFormat con el formato yyyy-MM-dd
            Date fechaNAcimientoDate = dateFormat.parse(fechaNacimiento);//tomo la fecha que esta como string y la parseo a date
            Date fechaActual = new Date();//tomo la fecha actual como punto de referencia para luego hacer el calculo en años
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");//inicializo un objeto SimpleDateFormat con un formato con el que podra hacer resta entre fechas y asi calcular los años del cliente
            int d1 = Integer.parseInt(formatter.format(fechaNAcimientoDate));//parseo la fecha de nacimiento del cliente a integer
            int d2 = Integer.parseInt(formatter.format(fechaActual));//parseo la fecha actual a integer
            int age = ((d2 - d1) / 10000);//realizo la resota y divicios correspondiente para obtener la cantidad de años del cliente
            clietnMap.put("Años", Integer.toString(age));//cargo al map los años del cleinte

            return clietnMap;
        }
    }
}

