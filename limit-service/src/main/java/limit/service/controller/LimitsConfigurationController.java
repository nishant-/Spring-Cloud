package limit.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import limit.service.bean.LimitConfiguration;
import limit.service.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping(path= {"/limits"})
    public LimitConfiguration retrieveLimitFromConfiguration() {
       LimitConfiguration limitConfiguration = LimitConfiguration.builder().
               maximum(configuration.getMaximum()).
               minimum(configuration.getMinimum()).build();
       return limitConfiguration;
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitConfiguration retrieveConfiguration() {
        throw new RuntimeException("config not available");
    }

    //this is the method which will be executed by Hystrix when exception occurs
    public LimitConfiguration fallbackRetrieveConfiguration() {
       return  LimitConfiguration.builder().maximum(1).minimum(12311).build();
    }
}
