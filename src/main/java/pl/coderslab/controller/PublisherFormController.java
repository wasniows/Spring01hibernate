package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class PublisherFormController {

    private final PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/deletepublisher/{id}")
    public String delete(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "redirect:/listofpublishers";
    }

    @RequestMapping("/editpublisher/{id}")
    public String edit(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "editPublisher";
    }

    @RequestMapping("/editpublisher")
    public String edit(@Valid Publisher publisher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "editPublisher";
        }
        publisherDao.update(publisher);
        return "redirect:/listofpublishers";
    }

    @GetMapping("/listofpublishers")
    public String list() {
        return "listOfPublishers";
    }

    @GetMapping("/addpublisher")
    public String form(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "addPublisher";
    }

    @PostMapping("/addpublisher")
    public String add(@Valid Publisher publisher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addPublisher";
        }
        publisherDao.savePublisher(publisher);
        return "redirect:/listofpublishers";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }
}
