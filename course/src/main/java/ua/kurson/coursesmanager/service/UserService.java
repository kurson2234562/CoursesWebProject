package ua.kurson.coursesmanager.service;

import java.util.List;

import ua.kurson.coursesmanager.model.*;

public interface UserService {

    public void lockUserById(Long id, Long state);

    public Users findUserByLogin(String login);

    public Users createUser(Users user);

    public List<Users> getAllUsers();

    public void registerUserOnCourse(Long id, Long idCourse);

    public void setNewPassword(Long id, String password);

    public void getUserById(Long id);

    public List<Courses> getAllCourses();

    public List<Roles> getAllRoles();

    public List getStudentsMarkById(Long id);

    public void deleteUserById(Long id);

    public List<Lecturers> getAllLecturers();

    public List<Statuses> getAllStatuses();

    public List<Themes> getAllThemes();
}
