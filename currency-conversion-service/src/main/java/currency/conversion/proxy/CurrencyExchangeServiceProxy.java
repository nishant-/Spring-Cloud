package currency.conversion.proxy;

import currency.conversion.dto.CurrencyConversionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

//this will use feign to talk to external ,microservice
//name -> provide the name of the service which you are going to call
//feign simplifies calling other microservices
@FeignClient(name="currency-exchange-service",url="localhost:8000")
public interface CurrencyExchangeServiceProxy {
    //currency-exchange -> is the URI o the service which feign will call
    @GetMapping("currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDto convertCurrency(@PathVariable("from") String from,
                                          @PathVariable("to") String to);




    }
