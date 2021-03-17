package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import java.util.List;

@RequestMapping(produces = "text/html; charset=UTF-8")
@Controller
public class PublisherController {

    public final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String addPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("ZNAK");
        publisherDao.savePublisher(publisher);
        Publisher publisher1 = new Publisher();
        publisher1.setName("Czarne");
        publisherDao.savePublisher(publisher1);
        Publisher publisher2 = new Publisher();
        publisher2.setName("Pruszyński");
        publisherDao.savePublisher(publisher2);
        return "Saved";
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping(path = "/publisher/get/all")
    @ResponseBody
    public String getAllPublishers(){
        List<Publisher> publishers = publisherDao.findAll();
        return publishers.toString();
    }


    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "publisher was deleted";
    }
}
