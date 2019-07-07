package limit.service.controller;

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
}
