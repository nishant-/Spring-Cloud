package currency.exchange.controller;


import currency.exchange.dto.ExchangeValueDTO;
import currency.exchange.entity.ExchangeValue;
import currency.exchange.repository.ExchangeValueRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {


    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValueDTO retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        int port = Integer.parseInt(environment.getProperty("local.server.port")); //local.server.port will give the port configured as server.port in application .properties
        //note vm args will override the values in properties file. -Dserver.port=<port>

        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from,to);

       /* return ExchangeValue.builder().id(10L).
                from(from).
                to(to).
                conversionMultiple(BigDecimal.valueOf(55)).port(port).build();*/
        exchangeValue.setPort(port);
        ModelMapper modelMapper = new ModelMapper();
        LOGGER.info("values -> {}", from,to);
        return modelMapper.map(exchangeValue,ExchangeValueDTO.class);

      /* return ExchangeValue.builder().id(10L).
                from(from).
                to(to).
                conversionMultiple(BigDecimal.valueOf(55)).port(port).build();*/
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
