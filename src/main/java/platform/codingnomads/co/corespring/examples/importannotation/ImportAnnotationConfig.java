package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({SimpleConfiguration.class, SampleConfiguration.class})
public class ImportAnnotationConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Framework framework() {
        return new Framework();
    }
}
