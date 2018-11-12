package simon.springframework.spring5webapp.bootstarp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import simon.springframework.spring5webapp.model.Author;
import simon.springframework.spring5webapp.model.Book;
import simon.springframework.spring5webapp.model.Publisher;
import simon.springframework.spring5webapp.repositories.AuthorRepository;
import simon.springframework.spring5webapp.repositories.BookRepository;
import simon.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
		
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher("New foo", "5353 Columbia Pike");
		//publisher.setName("foo");
		
		publisherRepository.save(publisher);
		
		
		Author simon = new Author("Simon", "Tadesse");
		Book book1 = new Book("Test New Book", "1234", publisher);
		
		simon.getBooks().add(book1);
		book1.getAuthors().add(simon);
		
		authorRepository.save(simon);
		bookRepository.save(book1);
		
		Author daniel = new Author("Daniel", "Tadesse");
		Book book2 = new Book("Trip to USA", "2314", publisher);
		daniel.getBooks().add(book2);
		book2.getAuthors().add(daniel);
		
		authorRepository.save(daniel);
		bookRepository.save(book2);
		
		daniel.getBooks().add(book1);
		book1.getAuthors().add(daniel);
		
		authorRepository.save(daniel);
		bookRepository.save(book1);
	
	}

	

}
