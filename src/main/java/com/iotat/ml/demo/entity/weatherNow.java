package com.iotat.ml.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather_now")

public class weatherNow {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "data")
    private String data;
    @Column(name = "temp")
    private String temp;

    public weatherNow() {
        super();
    }

    public weatherNow(String data, String temp) {
        super();
        this.data = data;
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String weatherdata) {
        this.data = weatherdata;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

}