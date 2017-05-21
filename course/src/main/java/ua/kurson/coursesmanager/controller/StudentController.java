package ua.kurson.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kurson.coursesmanager.dao.impl.UserDAOImpl;
import ua.kurson.coursesmanager.model.Students;
import ua.kurson.coursesmanager.model.Users;
import ua.kurson.coursesmanager.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired(required = true)
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student(Users user, Model model) {
        model.addAttribute("login", user.getLogin());
        model.addAttribute("student", new Students());
        Users userByLogin = new UserDAOImpl().findUserByLogin(user.getLogin());
        if (user.getIdUser() != 0) {
            model.addAttribute("listMarks", this.studentService.getStudentMarksById(user.getIdUser()));
        }
        return "/student";
    }

}
