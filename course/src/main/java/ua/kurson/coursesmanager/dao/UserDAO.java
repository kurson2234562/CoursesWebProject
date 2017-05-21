package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.*;

public interface UserDAO {

    public void lockUserById(Long id, Long state);

    public Users findUserByLogin(String login);

    public Users createUser(Users user);

    public List<Users> getAllUsers();

    public List<Courses> getAllCourses();

    public void registerUserOnCourse(Long id, Long idCourse);

    public void setNewPassword(Long id, String password);

    public Users getUserById(Long id);

    public List<Roles> getAllRoles();

    public List getStudentsMarkById(Long id);

    public void deleteUserById(Long id);

    public List<Lecturers> getAllLecturers();

    public List<Statuses> getAllStatuses();

    public List<Themes> getAllThemes();

}
