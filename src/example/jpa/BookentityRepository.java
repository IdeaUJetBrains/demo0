package example.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookentityRepository extends CrudRepository<Bookentity, Long> {
    List<Bookentity> findByTitle(String title);
}
