package platform.codingnomads.co.ioc.examples.constructorinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RAM {

    private String brand;
    private int memoryCapacity;
}
