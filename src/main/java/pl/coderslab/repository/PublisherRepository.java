package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findAllByNip(String nip);

    List<Publisher> findAllByRegon(String regon);
}
