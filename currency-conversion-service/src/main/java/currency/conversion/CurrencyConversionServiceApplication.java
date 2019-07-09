package currency.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//enable feign client and specify the packages to scan for clients
@EnableFeignClients("currency.conversion")
public class CurrencyConversionServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CurrencyConversionServiceApplication.class, args);
    }

}
