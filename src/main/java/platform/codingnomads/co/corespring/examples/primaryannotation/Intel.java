package platform.codingnomads.co.corespring.examples.primaryannotation;

import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("intel")
@ToString
@Primary
public class Intel implements Motherboard {
}
