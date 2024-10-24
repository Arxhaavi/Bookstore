package bookstore.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("asd", "Jonas Jonasson", 1991, "12345-12n", 12.3);
		Book book2 = new Book("dsa", "Koira Kissanen", 2052, "54321-21p", 20005.4);

		bookRepository.save(book1);
		bookRepository.save(book2);

		bookRepository.findAll().forEach(Book -> {
			System.out.println(Book);
		});
	}
}
