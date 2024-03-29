package ddd.rentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentManagementApplication.class, args);
    }

}
