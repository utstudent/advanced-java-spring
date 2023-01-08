package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {
    private Address address;
    private Background background;

    public SpringDeveloper(Address address, Background background) {

        this.address = address;
        this.background = background;
    }
}
