package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;

import javax.persistence.*;

@Entity
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private int capacity;

    @OneToOne(mappedBy = "engine")
    private Car car;
}
