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
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String address;

    @Column(nullable = false)
    private int sqrft;

    @ManyToMany
    private Set<Person> persons;

}

