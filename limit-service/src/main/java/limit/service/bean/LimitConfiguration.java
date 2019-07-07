package limit.service.bean;


import lombok.*;


@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LimitConfiguration {

    private int maximum;
    private int minimum;

}
