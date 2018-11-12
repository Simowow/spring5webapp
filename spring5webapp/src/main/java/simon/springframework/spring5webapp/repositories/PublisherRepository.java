package simon.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import simon.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
