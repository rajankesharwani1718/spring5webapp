package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Auther;
import org.springframework.data.repository.CrudRepository;

public interface AutherRepository extends CrudRepository<Auther,Long> {

}
