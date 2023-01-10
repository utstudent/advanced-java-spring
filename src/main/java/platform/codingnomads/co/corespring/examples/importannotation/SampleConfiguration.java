package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {

    private Framework framework2(){
        return new Framework();

    }
}
