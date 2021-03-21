package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.Collection;
import java.util.List;

@Controller
public class AuthorFormController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public AuthorFormController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/deleteauthor/{id}")
    public String delete(@PathVariable long id){
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/listofauthors";
    }

    @RequestMapping("/editauthor/{id}")
    public String editBook(@PathVariable long id, Model model){
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/editAuthor.jsp";
    }

    @RequestMapping("/editauthor")
    public String editAuthor (Author author){
        authorDao.update(author);
        return "redirect:/listofauthors";
    }

    @GetMapping("/listofauthors")
    public String listOfBooks(Model model){
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "listOfAuthors.jsp";
    }

    @GetMapping("/addauthor")
    public String formBook(Model model){
        model.addAttribute("author", new Author());
        return "/addAuthor.jsp";
    }

    @PostMapping("/addauthor")
    public String addBook (Author author, Model model){
        authorDao.saveAuthor(author);
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "redirect:/listofauthors";
    }

    @ModelAttribute("books")
    public Collection<Book> books(){
        return this.bookDao.findAll();
    }

}
