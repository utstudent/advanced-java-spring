package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private long id;
    private String make, model, year;
}
