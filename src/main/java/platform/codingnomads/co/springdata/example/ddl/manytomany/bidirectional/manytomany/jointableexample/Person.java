package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional.manytomany.jointableexample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            //change join table name
            name = "person_house_join_table",
            //specify a column named location_latitude referencing the latitude column in the locations table
            inverseJoinColumns = @JoinColumn(name = "address", referencedColumnName = "address")
    )
    private Set<House> houses;
}
