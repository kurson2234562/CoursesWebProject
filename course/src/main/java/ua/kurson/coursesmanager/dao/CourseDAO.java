package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.*;

public interface CourseDAO {
    public void createCourse(Courses courses);

    public void updateCourseById(Courses courses);

    public void deleteCourseByIdCourse(Long id);

    public Courses getCourseByIdCourse(Long id);

    public List<Courses> getAllCourses();

    public List<Courses> findCourseByString(String searchResult);

    public List<Courses> findAllCoursesThatUserNotRegistered(Long id);

    public List<Users> getAllUsers();

    public List<Lecturers> getAllLecturers();

    public List<Statuses> getAllStatuses();

    public List<Themes> getAllThemes();
}
