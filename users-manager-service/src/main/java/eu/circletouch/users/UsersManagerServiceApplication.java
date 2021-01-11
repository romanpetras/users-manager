package eu.circletouch.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersManagerServiceApplication.class, args);
    }

}
