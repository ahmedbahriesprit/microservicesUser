package tn.esprit.microservicesuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesUserApplication.class, args);
    }

}
