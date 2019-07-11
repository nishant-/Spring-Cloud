package currency.conversion.proxy;

import currency.conversion.dto.CurrencyConversionDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//this will use feign to talk to external ,microservice
//name -> provide the name of the service which you are going to call
//feign simplifies client code calling restful web services
//@FeignClient(name="currency-exchange-service"/*,url="localhost:8000" this is coomented and will be configured in prop file
//so that load can be balanced across multiple instances*/)
@RibbonClient(name="currency-exchange-service") //ribbon is used for client side load balancing
@FeignClient(name="zuul-api-gateway-server")  //Feign, talk to api gateway
public interface CurrencyExchangeServiceProxy {
    //currency-exchange -> is the URI o the service which feign will call
    //@GetMapping("currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDto convertCurrency(@PathVariable("from") String from,
                                          @PathVariable("to") String to);




    }
