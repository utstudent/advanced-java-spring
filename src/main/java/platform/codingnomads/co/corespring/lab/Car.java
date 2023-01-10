package platform.codingnomads.co.corespring.lab;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String make;
    private String model;
    private String year;
}
