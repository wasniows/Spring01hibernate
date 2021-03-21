package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import java.util.Collection;
import java.util.List;


@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/delaccept/{id}")
    public String delAccept(Model model, @PathVariable long id){
        model.addAttribute("id", id);
        return "/delAccept.jsp";
    }

    @RequestMapping("/delete/{id}")
     public String delete(@PathVariable long id){
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:/listofbooks";
    }

    @RequestMapping("/editbook")
    public String editBook (Book book){
        bookDao.update(book);
        return "redirect:/listofbooks";
    }


    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/editBook.jsp";
    }

    @GetMapping("/listofbooks")
    public String listOfBooks(Model model){
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "listOfBooks.jsp";
    }

    @GetMapping("/addbook")
    public String formBook(Model model){
        model.addAttribute("book", new Book());
        return "/addBook.jsp";
    }

    @PostMapping("/addbook")
    public String addBook (Book book, Model model){
        bookDao.saveBook(book);
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "redirect:/listofbooks";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public Collection<Author> authors(){
        return this.authorDao.findAll();
    }

//    @ModelAttribute("books")
//    public Collection<Book> books(){
//        return this.bookDao.findAll();
//    }
}
