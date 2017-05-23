package ua.kurson.coursesmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kurson.coursesmanager.model.Courses;
import ua.kurson.coursesmanager.model.Users;
import ua.kurson.coursesmanager.service.LecturerService;

@Controller
public class LecturerController {

    private static final Logger logger = LoggerFactory.getLogger(LecturerController.class);

    private LecturerService lecturerService;

    @Autowired(required = true)
    @Qualifier(value = "lecturerService")
    public void setLecturerService(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @RequestMapping(value = "/lecturer", method = RequestMethod.GET)
    public String listCourses(Model model, Users user) {
        Users findUser = lecturerService.findUserByLogin(user.getLogin());
        model.addAttribute("markedList", this.lecturerService.findMarkedStudentsOnCourseByLecturersId(findUser.getIdUser()));
        model.addAttribute("notMarkedList", this.lecturerService.findNotMarkedStudentsOnCourseByLecturersId(findUser.getIdUser()));
        System.out.println(findUser.getIdUser());
        model.addAttribute("course", new Courses());
        model.addAttribute("login", user.getLogin());
        System.out.println(findUser.getIdUser());
        return "/lecturer";
    }
}
