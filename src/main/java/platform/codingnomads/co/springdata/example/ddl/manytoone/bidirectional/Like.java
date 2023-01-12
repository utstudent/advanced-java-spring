package platform.codingnomads.co.springdata.example.ddl.manytoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import platform.codingnomads.co.springdata.example.ddl.manytoone.unidirectional.usingmanytoone.Comment;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String username;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    private Post post;


}
