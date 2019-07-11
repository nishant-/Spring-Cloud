package limit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix //enables hystrix on all controller methods
public class LimitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitServiceApplication.class, args);
    }

}
