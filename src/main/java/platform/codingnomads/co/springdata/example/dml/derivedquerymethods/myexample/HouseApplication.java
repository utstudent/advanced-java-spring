package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
public class HouseApplication implements CommandLineRunner {

    @Autowired
    HouseRepo houseRepo;

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        House house1 = House.builder().address("123 Washington").bathroomNum(2).bedroomNum(3).yearBuilt(2010).build();
        House house2 = House.builder().address("123 Texas").bathroomNum(3).bedroomNum(6).yearBuilt(2021).build();
        House house3 = House.builder().address("123 California").bathroomNum(4).bedroomNum(7).yearBuilt(2002).build();
        House house4 = House.builder().address("123 New York").bathroomNum(1).bedroomNum(2).yearBuilt(1930).build();

        houseRepo.saveAll(List.of(house1,house2, house3, house4));

        System.out.println("*******************findByBedroomNumIs******************");
        final List<House> findByBedroomNumIs = houseRepo.findByBedroomNumIs(3);
        findByBedroomNumIs.forEach(System.out::println);

        System.out.println("*******************findByBedroomNumGreaterThan******************");
        final List<House> findByBedroomNumGreaterThan = houseRepo.findByBedroomNumGreaterThan(2);
        findByBedroomNumGreaterThan.forEach(System.out::println);

//        System.out.println("*******************findByBedroomNumGreaterThan******************");
//        final List<House> findByBedroomNumGreaterThan = houseRepo.findByBedroomNumGreaterThan(2);
//        findByBedroomNumGreaterThan.forEach(System.out::println);
    }
}
