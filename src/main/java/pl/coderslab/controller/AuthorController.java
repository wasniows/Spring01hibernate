package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Objects;

@RequestMapping(produces = "text/html; charset=UTF-8")
@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        Author author1 = new Author();
        author1.setFirstName("Adam");
        author1.setLastName("Mickiewicz");
        author.setFirstName("Szczepan");
        author.setLastName("Twardoch");
        authorDao.saveAuthor(author);
        authorDao.saveAuthor(author1);
        return "Id dodanego autora to: " + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping(path = "/author/get/all")
    @ResponseBody
    public String getAllAuthors(){
        List<Author> authors = authorDao.findAll();
        return authors.toString();
    }


    @RequestMapping("/author/update/{id}/{firstName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "author was deleted";
    }
}
