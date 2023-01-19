package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.House;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

        final List<Area> areas = areaRepository.saveAll(
                Arrays.asList(
                        Area.builder().code("G").build(),
                        Area.builder().code("H").build(),
                        Area.builder().code("Y").build(),
                        Area.builder().code("Z").build(),
                        Area.builder().code("T").build(),
                        Area.builder().code("A").build(),
                        Area.builder().code("E").build(),
                        Area.builder().code("V").build()
                )
        );

        System.out.println("*******************findByCode******************");
        final List<Area> findByCode = areaRepository.findByCode("T");
        findByCode.forEach(System.out::println);

        areaRepository.deleteAll();



    }
}
