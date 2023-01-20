package com.example.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogserviceApplication.class, args);
    }

}
