package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.UserDAO;
import ua.kurson.coursesmanager.model.*;
import ua.kurson.coursesmanager.model.view.JournalView;
import ua.kurson.coursesmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void lockUserById(Long id) {
        this.userDAO.lockUserById(id);
    }

    @Override
    @Transactional
    public void getUserById(Long id) {
        this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public Users findUserByLogin(String login) {
        return this.userDAO.findUserByLogin(login);
    }

    @Override
    @Transactional
    public Users createUser(Users user) {
        return this.userDAO.createUser(user);
    }

    @Override
    @Transactional
    public List<Users> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void registerUserOnCourse(Long id, Long idCourse) {
        this.userDAO.registerUserOnCourse(id, idCourse);
    }

    @Override
    @Transactional
    public void setNewPassword(Long id, String password) {
        this.userDAO.setNewPassword(id, password);
    }

    @Override
    @Transactional
    public List<Courses> getAllCourses() {
        return this.userDAO.getAllCourses();
    }

    @Override
    @Transactional
    public List<Roles> getAllRoles() {
        return this.userDAO.getAllRoles();
    }

    @Override
    @Transactional
    public List<Statuses> getAllStatuses() {
        return this.userDAO.getAllStatuses();
    }

    @Override
    @Transactional
    public List<Themes> getAllThemes() {
        return this.userDAO.getAllThemes();
    }

    @Override
    @Transactional
    public List<Lecturers> getAllLecturers() {
        return this.userDAO.getAllLecturers();
    }

    @Override
    @Transactional
    public List<JournalView> getStudentsMarkById(Long id) {
        return this.userDAO.getStudentsMarkById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        this.userDAO.deleteUserById(id);
    }
}
