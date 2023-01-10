package platform.codingnomads.co.corespring.examples.primaryannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("amd")
@ToString
public class AMD implements Motherboard {
}
