//package platform.codingnomads.co.springdata.example.springdatajdbc;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@SpringBootApplication
//public class SpringDataJDBCDemo2 implements CommandLineRunner {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringDataJDBCDemo2.class);
//    }
//
//    @Override
//    public void run(String... strings) {
//
//        try {
//            //create car table using the JdbcTemplate method "execute"
//            jdbcTemplate.execute("CREATE TABLE cars (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
//                    "make VARCHAR(255) NOT NULL,model VARCHAR(255) NOT NULL, year VARCHAR(255) NOT NULL);");
//        } catch (Exception e) {
//            //nothing
//        }
//
//        //create a list of cars
//        List<Object[]> splitUpNames = Stream.of("Honda Pilot 2019", "Toyota Supra 2021", "Bugatti Chiron 2020", "Toyota Camry 1998")
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        //for each car attribute insert a car into the database
//        for (Object[] name : splitUpNames) {
//            jdbcTemplate.execute(String.format("INSERT INTO cars(make, model, year) VALUES ('%s','%s','%s')", name[0], name[1], name[2]));
//        }
//
//        //query the database for cars
//        jdbcTemplate.query(
//                        "SELECT id, make, model, year FROM cars",
//                        (rs, rowNum) -> new Car(rs.getLong("id"), rs.getString("make"), rs.getString("model"), rs.getString("year"))
//                )
//                //print each found car to the console
//                .forEach(car -> System.out.println(car.toString()));
//
//        //delete the table
//        jdbcTemplate.execute("DROP TABLE cars");
//    }
//}
