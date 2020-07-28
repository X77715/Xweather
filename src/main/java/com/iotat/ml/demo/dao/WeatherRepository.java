package com.iotat.ml.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.iotat.ml.demo.entity.weatherNow;


public interface WeatherRepository extends JpaRepository<weatherNow, Integer> {

}
