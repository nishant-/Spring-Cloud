package currency.exchange.controller;


import currency.exchange.entity.ExchangeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        return ExchangeValue.builder().id(10L).
                from(from).
                to(to).
                conversionMultiple(BigDecimal.valueOf(55)).build();
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
