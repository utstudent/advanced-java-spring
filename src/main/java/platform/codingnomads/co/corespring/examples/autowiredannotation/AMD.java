package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("amd")
@ToString
public class AMD implements Motherboard{
}
