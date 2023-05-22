package ddd.vehiclelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VehicleListApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleListApplication.class, args);
    }

}
