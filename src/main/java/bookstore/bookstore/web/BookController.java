package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@Controller
public class BookController {
     @Autowired
     private BookRepository bookRepository;

     @RequestMapping(value = { "/", "/booklist" })
     public String getBookList(Model model) {
          model.addAttribute("books", bookRepository.findAll());
          return "booklist";
     }

     @RequestMapping("/add")
     public String addBook(Model model) {
          model.addAttribute("book", new Book());
          return "addbook";
     }

     @RequestMapping(value = "/save", method = RequestMethod.POST)
     public String save(Book book) {
          bookRepository.save(book);
          return "redirect:booklist";
     }
}
