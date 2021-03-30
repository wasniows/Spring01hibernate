package pl.coderslab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, message = "{firstName.min}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{lastName.min}")
    private String lastName;

    @PESEL(message = "{wrong.pesel}")
    private String pesel;

    @Email(message = "{wrong.email}")
    private String email;

    @ManyToMany(mappedBy = "authorList", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();


    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}
