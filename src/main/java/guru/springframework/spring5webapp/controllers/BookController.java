package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//tells the spring framework our intent is to make this into a spring MVC controller
public class BookController {
    //ask spring framework to inject the book repository using Spring dependency injection
    private final BookRepository bookRepository;

    //with a constructor created, the repository is a spring managed component because it is
    //controller, when spring instantiates this it will inject and instance of that book repository into our controller
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    // model gives us the model object and this is what's gonna return to the view
    public String getBooks(Model model) {
        //when spring gets a request to the URL:/books, it's going to execute the getBooks
        //method and provide this method a model. For this model, we are going to add an attribute
        //called Books and we are going to execute book repository which is going to give us a list of books
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
