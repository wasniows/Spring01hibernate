package pl.coderslab.entity;

import lombok.Data;
import net.bytebuddy.build.Plugin;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, message = "{title.must.be.min}" )
    private String title;

    @Range(min = 1, max = 10)
    private int rating;

    @Size(max = 600)
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @ManyToOne
    private Publisher publisher;

    @NotNull
    @Size(min = 1, message = "{size.authorList.must.min}")
    @ManyToMany( fetch = FetchType.EAGER)
    private List<Author> authorList = new ArrayList<>();

    @Min(1)
    private int pages;

    @ManyToOne
    private Category category;

}
