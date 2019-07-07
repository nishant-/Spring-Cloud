package currency.exchange.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeValue {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
