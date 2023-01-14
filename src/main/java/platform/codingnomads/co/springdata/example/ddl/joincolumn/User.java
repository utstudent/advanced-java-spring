package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //use @JoinColumns to indicate multiple join columns are needed in the examples table
    @JoinColumns({
            //define the first join column. It will be called referenced_id and references the id column in the user table
            @JoinColumn(name = "state", referencedColumnName = "state"),
            //define the second join column. It will be called references_name and references the name column in the user table
            @JoinColumn(name = "zipcode", referencedColumnName = "zipcode")
    })
    private Address address;
}
