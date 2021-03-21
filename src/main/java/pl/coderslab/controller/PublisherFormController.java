package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.Collection;
import java.util.List;

@Controller
public class PublisherFormController {

    private final PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/deletepublisher/{id}")
    public String delete(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "redirect:/listofpublishers";
    }

    @RequestMapping("/editpublisher/{id}")
    public String edit(@PathVariable long id, Model model){
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "/editPublisher.jsp";
    }

    @RequestMapping("/editpublisher")
    public String edit (Publisher publisher){
        publisherDao.update(publisher);
        return "redirect:/listofpublishers";
    }

    @GetMapping("/listofpublishers")
    public String listOfBooks(Model model){
//        List<Publisher> publishers = publisherDao.findAll();
//        model.addAttribute("publishers", publishers);
        return "listOfPublishers.jsp";
    }

    @GetMapping("/addpublisher")
    public String form(Model model){
        model.addAttribute("publisher", new Publisher());
        return "/addPublisher.jsp";
    }

    @PostMapping("/addpublisher")
    public String add (Publisher publisher, Model model){
        publisherDao.savePublisher(publisher);
//        List<Publisher> publishers = publisherDao.findAll();
//        model.addAttribute("publishers", publishers);
        return "redirect:/listofpublishers";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers(){
        return this.publisherDao.findAll();
    }
}
