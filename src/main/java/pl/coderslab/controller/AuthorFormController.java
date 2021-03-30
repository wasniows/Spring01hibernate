package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.validation.Valid;
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
        return "editAuthor";
    }

    @RequestMapping("/editauthor")
    public String editAuthor (@Valid Author author, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "editAuthor";
        }
        authorDao.update(author);
        return "redirect:/listofauthors";
    }

    @GetMapping("/listofauthors")
    public String listOfBooks(Model model){
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "/listOfAuthors";
    }

    @GetMapping("/addauthor")
    public String formBook(Model model){
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/addauthor")
    public String addBook (@Valid Author author, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "addAuthor";
        }
        authorDao.saveAuthor(author);
        return "redirect:/listofauthors";
    }

    @ModelAttribute("books")
    public Collection<Book> books(){
        return this.bookDao.findAll();
    }

}
