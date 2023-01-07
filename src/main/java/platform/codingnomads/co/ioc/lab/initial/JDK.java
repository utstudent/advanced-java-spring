package platform.codingnomads.co.ioc.lab.initial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JDK {
    private String name;
    private String version;
}