package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "auther_book", joinColumns =   @JoinColumn(  name ="book_id"), inverseJoinColumns = @JoinColumn(name ="auther_id"))
    private Set<Auther> authers = new HashSet<Auther>();

    @ManyToOne
    private  Publisher publisher;

    public Book(String hee, String kjj, Publisher publisher) {
    }

    public Book(String title, String isbn, Set<Auther> authers, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.authers = authers;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Auther> getAuthers() {
        return authers;
    }

    public void setAuthers(Set<Auther> authers) {
        this.authers = authers;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authers=" + authers +
                ", publisher=" + publisher +
                '}';
    }
}
