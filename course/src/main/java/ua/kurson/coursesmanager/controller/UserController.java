package ua.kurson.coursesmanager.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.kurson.coursesmanager.dao.impl.UserDAOImpl;
import ua.kurson.coursesmanager.model.Courses;
import ua.kurson.coursesmanager.model.Roles;
import ua.kurson.coursesmanager.model.States;
import ua.kurson.coursesmanager.model.Users;
import ua.kurson.coursesmanager.service.UserService;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login/authorization", method = RequestMethod.GET)
    public String authorization(Model model) {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("listUsers", this.userService.getAllUsers());
        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(@ModelAttribute("user") Users user, Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("listUsers", this.userService.getAllUsers());
        model.addAttribute("roles", this.userService.getAllRoles());
        return "/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam(value = "confirm") String confirmPassword, @RequestParam(value = "password") String password,
                           @RequestParam(value = "role") long idRole, @ModelAttribute("user") @Valid Users user, Model model) {
        user.setStatesByIdState(new States(1));
        user.setRolesByIdRole(new Roles(idRole));
        if (confirmPassword.equals(password)) {
            this.userService.createUser(user);
            return "/login";
        } else {
            return "redirect:/registration";
        }
    }

    @RequestMapping(value = "/removeUser/{id}", method = RequestMethod.GET)
    public String removeCourse(@PathVariable("id") Long id, Model model) {
        this.userService.deleteUserById(id);
        model.addAttribute("listUsers", this.userService.getAllUsers());
        return "redirect:/courses";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
    public String loginProcess(Users login, Model model) {
        Users user = userService.findUserByLogin(login.getLogin());
        if (user != null && user.getPassword().equals(login.getPassword())) {
            model.addAttribute("course", new Courses());
            model.addAttribute("login", user.getLogin());
            model.addAttribute("roles", this.userService.getAllRoles());
            model.addAttribute("listStatuses", this.userService.getAllStatuses());
            model.addAttribute("listLecturers", this.userService.getAllLecturers());
            model.addAttribute("listThemes", this.userService.getAllThemes());
            model.addAttribute("listUsers", this.userService.getAllUsers());
            model.addAttribute("listCourses", this.userService.getAllCourses());
            if (user.getRolesByIdRole().getIdRole() == 0) {
                return "/courses";
            } else if (user.getRolesByIdRole().getIdRole() == 1) {
                if (user.getIdUser() == 0) {
                    Users userByLogin = new UserDAOImpl().findUserByLogin(user.getLogin());
                    model.addAttribute("journal",
                            this.userService.getStudentsMarkById(userByLogin.getIdUser()));
                    return "/student";
                } else {
                    model.addAttribute("journal",
                            this.userService.getStudentsMarkById(user.getIdUser()));
                    return "/student";
                }
            } else {
                return "/lecturer";
            }
        } else {
            return "/login";
        }
    }
}
