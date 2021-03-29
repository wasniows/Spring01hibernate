package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;

    @GetMapping("test")
    String test(){
        return "test";
    }


    @GetMapping(value = "form/book/search", params = "title")
    String findAllBooksByTitle(@RequestParam("title") String title, Model model){

        List<Book> books = bookRepository.findAllByTitle(title);
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @GetMapping(value = "form/book/search", params = "author")
    String findAllBooksByAuthor(@RequestParam("author") Author author, Model model){

        List<Book> books = bookRepository.findAllByAuthorList(author);
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @RequestMapping("/delaccept/{id}")
    public String delAccept(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        return "/delAccept";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:/listofbooks";
    }

    @RequestMapping("/editbook")
    public String editBook(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "/editBook";
        }

        bookDao.update(book);
        return "redirect:/listofbooks";
    }


    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/editBook";
    }

    @GetMapping("/listofbooks")
    public String listOfBooks(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @GetMapping("/addbook")
    public String formBook(Model model) {
        model.addAttribute("book", new Book());
        return "/addBook";
    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addBook";
        }

        bookDao.saveBook(book);
        return "redirect:/listofbooks";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public Collection<Author> authors() {
        return this.authorDao.findAll();
    }

    @ModelAttribute("books")
    public Collection<Book> books() {
        return this.bookDao.findAll();
    }
}
