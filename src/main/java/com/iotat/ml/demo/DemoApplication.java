package com.iotat.ml.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.iotat.ml.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("helloworld");
        SpringApplication.run(DemoApplication.class, args);
    }

}
