package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("understanding_and_using_profiles")
public class SpringTechLead {

    public SpringTechLead() {
        System.out.println("SpringTechLead is ready!");
    }
}
