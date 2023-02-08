package pl.coderslab.person;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setCity("Warsaw");
        personDetails.setFirstName("Maria");
        personDetails.setLastName("Rokita");
        personDetails.setStreet("Brzozowa");
        personDetails.setStreetNumber(44);
        personDetailsDao.savePersonDetails(personDetails);

        Person person = new Person();
        person.setDetails(personDetails);

        person.setEmail("test@wp.pl");
        person.setLogin("rybak101");
        person.setPassword("pawiany_wchodza_na_sciany087");
        personDao.savePerson(person);
        return "Created person id: " + person.getId() + "\n" + person.toString();
    }

    @RequestMapping("/person/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }

    @RequestMapping("/person/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        Person person = personDao.findById(id);
//        PersonDetails personDetails = personDetailsDao.findById(person.getDetails().getId());
//        personDetailsDao.delete(personDetails);
        personDao.delete(person);
        return "deleted";
    }

    @RequestMapping("/person/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login) {
        Person person = personDao.findById(id);
        person.setLogin(login);
        personDao.update(person);
        return person.toString();
    }
    @ModelAttribute("languages")
    public List<String> getLanguages() {
        return List.of("java", "php", "ruby", "python");
    }

    @GetMapping("/person/addform")
    public String addPersonForm(Model model) {
//        List<String> languages = List.of("java", "php", "ruby", "python");
//        model.addAttribute("languages",languages);

        Person person = personDao.findById(1);
        model.addAttribute("person", person);
        return "/person/addform";
    }

//    @PostMapping("/person/addform")
//    @ResponseBody
//    public String returnPersonForm(@RequestParam String login,
//                                   @RequestParam String password,
//                                   @RequestParam String email){
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personDao.savePerson(person);
//        return person.toString();
//    }

    @PostMapping("/person/addform")
    @ResponseBody
    public String returnPersonForm(Person person, Model model) {
        personDao.savePerson(person);
        return person.toString();
    }
}
