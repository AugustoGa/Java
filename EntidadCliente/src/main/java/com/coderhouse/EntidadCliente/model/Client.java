package com.coderhouse.EntidadCliente.model;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.Date;

import java.text.SimpleDateFormat;


@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//esto genera auto incremental del id en la tabla
    private int id;
    private String name;
    private String lastname;
    private String docnumber;
    private Date yearbirth;

    /*public Client(int id, String name, String lastname, String docnumber, Date yearbirth) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
        this.yearbirth = yearbirth;
    }


    public Client(int id, String name, String lastname, String docnumber, String yearBirthString) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
        setYearbirth(yearBirthString);
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }


    public Date getYearbirth() {
        return yearbirth;
    }

    public void setYearbirth(Date yearBirthDate) {
        this.yearbirth = yearBirthDate;
    }
    //sobre cargo el metodo setYearBirth
    public void setYearbirth(String yearbirth) {
        String pattern = "dd-MM-yyyy";
        Date yearBirthDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            yearBirthDate = dateFormat.parse(yearbirth);
            System.out.println(yearBirthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.yearbirth = yearBirthDate;
    }




    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", docNumber='" + docnumber + '\'' +
                ", yearBirth=" + yearbirth +
                '}';
    }







}
