package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
    public final static String SAY_HELLO_ENDPOINT = "http://say-hello";

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}