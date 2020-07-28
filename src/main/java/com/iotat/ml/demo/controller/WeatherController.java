package com.iotat.ml.demo.controller;


import com.iotat.ml.demo.servecs.getWeatherValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

        import java.io.IOException;


@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    getWeatherValue getweathervalue;

    @RequestMapping("/upWeatherData")
    @ResponseBody
    public void upWeatherData() throws IOException {

        getweathervalue.getweatherdata();
    }
}