package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;


@Controller
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping(path = "/validate")
    String validate(Book book, Model model) {
        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        model.addAttribute("errors", errors);
        return "errors";
    }

    @GetMapping(path = "/validate/publisher")
    String validate(Publisher publisher, Model model) {
        Set<ConstraintViolation<Publisher>> errors = validator.validate(publisher);
        model.addAttribute("errors", errors);
        return "errors";
    }

    @GetMapping(path = "/validate/author")
    String validate(Author author, Model model) {
        Set<ConstraintViolation<Author>> errors = validator.validate(author);
        model.addAttribute("errors", errors);
        return "errors";
    }


//    @GetMapping(path = "/validate", produces = "text/plain;charset=UTF-8")
//    String validate(Book book) {
//        Set<ConstraintViolation<Book>> errors = validator.validate(book);
//        if (errors.isEmpty()) {
//            return "Nie ma błędów";
//        } else {
//            return errors.stream()
//                    .map(cv -> cv.getPropertyPath() + ":" + cv.getMessage())
//                    .collect(Collectors.joining(","));
//        }
//    }

}

