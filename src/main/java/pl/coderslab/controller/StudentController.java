package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(produces = "text/html; charset=UTF-8")
public class StudentController {


    @GetMapping("/addstudent")
    public String formStudent(Model model){
        model.addAttribute("student", new Student());
        return "addStudent.jsp";
    }

    @PostMapping("/addstudent")
    @ResponseBody
    public String showStudent(Student student){
        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Tenis", "Filmy", "Narty", "Podróże", "Komputery");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        return Arrays.asList("Java", "Hibernate", "Scrum", "JavaScript", "Basic");
    }
}
