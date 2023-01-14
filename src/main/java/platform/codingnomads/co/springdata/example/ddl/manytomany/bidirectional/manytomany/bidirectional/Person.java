//package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional.manytomany.bidirectional;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Person {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, updatable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private int age;
//
//    @ManyToMany(mappedBy = "persons")
//    private Set<House> houses;
//}
