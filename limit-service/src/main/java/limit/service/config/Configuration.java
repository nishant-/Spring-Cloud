package limit.service.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {

    private int minimum;
    private int maximum;
}
