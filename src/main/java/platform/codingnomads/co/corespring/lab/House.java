package platform.codingnomads.co.corespring.lab;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private int sqrfeet;
    private String yearBuilt;
    private int roomCount;
    private int bathroomCount;
}
