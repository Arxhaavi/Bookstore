package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
