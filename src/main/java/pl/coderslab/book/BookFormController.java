package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherDao;

import java.util.List;

@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }
    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }
    @ModelAttribute("authors")
    public List<Author> authors(){return authorDao.findAll();}

    @GetMapping("/book/new")
    public String newBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/new";
    }

    @PostMapping("/book/save")
    public String saveBook(Book book) {
        bookDao.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String listBooks(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "/book/list";
    }

    @GetMapping("/book/edit/{id}")
    public String editBook(Model model, @PathVariable int id) {
        //fetch book by id
        //pass book to model
        //return view
        Book book = bookDao.findById(id);
        model.addAttribute(book);
        return "/book/edit";
    }

    @PostMapping("/book/update")
    public String updateBook(Book book) {
        //update book
        //setter do id potrzebny
        bookDao.update(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBookForm(Model model, @PathVariable int id) {
        //pass id to model
        //display form with OK and Cancel
        //Cancel - link to book list
        //OK - post to delete action
        Book book = bookDao.findById(id);
        model.addAttribute(book);
        return "/book/delete";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        //find book by id
        //delete book
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:/book/list";
    }


}
