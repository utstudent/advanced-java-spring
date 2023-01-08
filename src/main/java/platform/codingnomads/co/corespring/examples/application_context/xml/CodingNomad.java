package platform.codingnomads.co.corespring.examples.application_context.xml;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;
    private final Computer computer;



    @Autowired
    private OS os;



    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This coding nomad is creating awesome software using, " +
                                "\nIDE: ({0}:{1}), \nJDK: ({2}:{3}), \nFramework: ({4}:{5}), \nComputer: ({6}), \nOS: ({7})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        computer.getBrand(),
                        os.getOSName()
                );
    }
}
