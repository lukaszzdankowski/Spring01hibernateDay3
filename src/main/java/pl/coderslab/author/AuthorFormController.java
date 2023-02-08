package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.book.Book;

import java.util.List;

@Controller
public class AuthorFormController {
    private final AuthorDao authorDao;


    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/author/list")
    public String listAuthor(Model model) {
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "/author/list";
    }
    @GetMapping("/author/new")
    public String newAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "/author/new";
    }
    @PostMapping("/author/save")
    public String saveAuthor(Author author) {
        authorDao.saveAuthor(author);
        return "redirect:/author/list";
    }

    @GetMapping("/author/delete/{id}")
    public String deleteAuthorForm(Model model, @PathVariable int id) {
        Author author = authorDao.findById(id);
        model.addAttribute(author);
        return "/author/delete";
    }

    @PostMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable int id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/author/list";
    }

    @GetMapping("/author/edit/{id}")
    public String editAuthor(Model model, @PathVariable int id) {
        Author author = authorDao.findById(id);
        model.addAttribute(author);
        return "/author/edit";
    }
    @PostMapping("/author/update")
    public String updateAuthor(Author author) {
        authorDao.update(author);
        return "redirect:/author/list";
    }
}
