package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonalDetailsDao;
import pl.coderslab.entity.*;

@RequestMapping(produces = "text/html; charset=UTF-8")
@Controller
public class PersonController {

    private final PersonDao personDao;
    private final PersonalDetailsDao personalDetailsDao;

    public PersonController(PersonDao personDao, PersonalDetailsDao personalDetailsDao) {
        this.personDao = personDao;
        this.personalDetailsDao = personalDetailsDao;
    }

    @RequestMapping( path = "/person/add" )
    @ResponseBody
    public String addPerson(){
        Person person = new Person();
        PersonDetails personDetails = new PersonDetails();
        person.setLogin("kowal");
        person.setPassword("ljkjkhjh4fr-LK");
        person.setEmail("kowal@onet.pl");
        person.setPersonDetails(personDetails);
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        personDetails.setCity("Kraków");
        personDetails.setStreet("Podwale");
        personDetails.setStreetNumber("23/2");
        personalDetailsDao.savePersonDetails(personDetails);

        personDao.savePerson(person);

        return "Id dodanej osoby to: " + person.getId();
    }

    @RequestMapping(path = "/person/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id){
        Person person = personDao.findById(id);
        return person.toString();
    }

    @RequestMapping(path = "/person/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login){
        Person person = personDao.findById(id);
        person.setLogin(login);
        personDao.update(person);
        return person.toString();
    }

    @RequestMapping(path = "/person/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id){
        Person person = personDao.findById(id);
        PersonDetails personDetails = person.getPersonDetails();
        personDao.delete(person);
        personalDetailsDao.delete(personDetails);
        return " person deleted";
    }



}
