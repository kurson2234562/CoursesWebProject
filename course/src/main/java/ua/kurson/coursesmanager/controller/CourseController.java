package ua.kurson.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kurson.coursesmanager.model.Courses;
import ua.kurson.coursesmanager.service.CourseService;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String listCourses(Model model) {
        model.addAttribute("courses", new Courses());
        model.addAttribute("listCourses", this.courseService.getAllCourses());
        model.addAttribute("listUsers", this.courseService.getAllUsers());
        return "/courses";
    }

    @RequestMapping(value = "/courses/add", method = RequestMethod.GET)
    public String addCourse(@ModelAttribute("courses") Courses courses) {
        if (courses.getIdCourse() == 0) {
            this.courseService.createCourse(courses);
        } else {
            this.courseService.updateCourseById(courses);
        }

        return "redirect:/courses";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeCourse(@PathVariable("id") Long id, Model model, String login) {
        model.addAttribute("login", login);
        model.addAttribute("courses", new Courses());
        model.addAttribute("listCourses", this.courseService.getAllCourses());
        model.addAttribute("listUsers", this.courseService.getAllUsers());
        //ToDo: do not delete redirect!
        return "redirect:/courses";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editCourse(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course", this.courseService.getCourseByIdCourse(id));
        model.addAttribute("listCourses", this.courseService.getAllCourses());
        model.addAttribute("listStatuses", this.courseService.getAllStatuses());
        model.addAttribute("listLecturers", this.courseService.getAllLecturers());
        model.addAttribute("listThemes", this.courseService.getAllThemes());
        model.addAttribute("listUsers", this.courseService.getAllUsers());
        return "/courses";
    }

    @RequestMapping(value = "courseData/{id}", method = RequestMethod.GET)
    public String courseData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course", this.courseService.getCourseByIdCourse(id));

        return "/courseData";
    }

}
