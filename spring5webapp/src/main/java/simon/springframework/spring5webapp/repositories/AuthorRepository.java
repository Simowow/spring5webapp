package simon.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import simon.springframework.spring5webapp.model.Author;

/**
 * @author skiflemariam
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
