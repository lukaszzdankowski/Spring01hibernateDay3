package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("skills")
    public List<String> skills() {
        return List.of("java", "php", "ruby", "python");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("gry komputerowe", "narty", "football", "sex", "piwo");
    }

    @GetMapping("/student/add")
    public String addStudentForm(Model model) {
        Student student = new Student();
        student.setId(new Random().nextLong());
        model.addAttribute("student", student);
        return "/student/addstudent";
    }
    @PostMapping("/student/add")
    @ResponseBody
    public String returnStudentForm(Student student) {
        return student.toString();
    }

}
