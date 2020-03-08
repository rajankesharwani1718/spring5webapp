package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Auther;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AutherRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AutherRepository autherRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AutherRepository autherRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.autherRepository = autherRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Auther eric = new Auther("Eric", "Evans");
        Publisher publisher = new Publisher("Rajan", "845 B ", "Allahabad","Uttar Pradeesh","211008");

        Book add = new Book("Hee","kjj",publisher);

        eric.getBooks().add(add);
        add.getAuthers().add(eric);

        publisher.getBooks().add(add);

       // bookRepository.save(add);
        autherRepository.save(eric);

        publisherRepository.save(publisher);


        System.out.println(add.getAuthers().size());
    }
}
