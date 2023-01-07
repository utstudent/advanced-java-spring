package platform.codingnomads.co.ioc.examples.constructorinjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class GPU {
    private String model;
    private int videoMemoryCapacity;
}
