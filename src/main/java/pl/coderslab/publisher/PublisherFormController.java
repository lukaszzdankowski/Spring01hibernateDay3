package pl.coderslab.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherFormController {
    private final PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/publisher/list")
    public String listPublisher(Model model) {
        List<Publisher> publishers = publisherDao.findAll();
        model.addAttribute("publishers", publishers);
        return "/publisher/list";
    }

    @GetMapping("/publisher/new")
    public String newPublisher(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "/publisher/new";
    }

    @PostMapping("/publisher/save")
    public String savePublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/publisher/delete/{id}")
    public String deletePublisherForm(Model model, @PathVariable int id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute(publisher);
        return "/publisher/delete";
    }

    @PostMapping("/publisher/delete/{id}")
    public String deletePublisher(@PathVariable int id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/publisher/edit/{id}")
    public String editPublisher(Model model, @PathVariable int id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute(publisher);
        return "/publisher/edit";
    }

    @PostMapping("/publisher/update")
    public String updatePublisher(Publisher publisher) {
        publisherDao.update(publisher);
        return "redirect:/publisher/list";
    }
}
