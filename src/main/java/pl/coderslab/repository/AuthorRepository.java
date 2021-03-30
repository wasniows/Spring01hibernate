package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByEmail(String email);
    List<Author> findAllByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);

}
