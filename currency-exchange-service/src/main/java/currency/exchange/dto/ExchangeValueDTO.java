package currency.exchange.dto;


import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeValueDTO {

    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    int port;
}
