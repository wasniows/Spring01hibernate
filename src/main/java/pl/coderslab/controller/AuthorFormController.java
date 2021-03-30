package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
public class AuthorFormController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final AuthorRepository authorRepository;



    @GetMapping(value = "form/author/search", params = "pesel")
    String findAllByPesel(@RequestParam("pesel") String pesel, Model model){

        List<Author> authors = authorRepository.findAllByPesel(pesel);
        model.addAttribute("authors", authors);
        return "listOfAuthors";
    }

    @GetMapping(value = "form/author/search", params = "email")
    String findAllByEmail(@RequestParam("email") String email, Model model){

        List<Author> authors = authorRepository.findAllByEmail(email);
        model.addAttribute("authors", authors);
        return "listOfAuthors";
    }

    @GetMapping(value = "form/author/search", params = "lastName")
    String findAllByLastName(@RequestParam("lastName") String lastName, Model model){

        List<Author> authors = authorRepository.findAllByLastName(lastName);
        model.addAttribute("authors", authors);
        return "listOfAuthors";
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
