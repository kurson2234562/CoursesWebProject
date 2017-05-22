package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.CourseDAO;
import ua.kurson.coursesmanager.model.*;
import ua.kurson.coursesmanager.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    @Transactional
    public void createCourse(Courses courses) {
        this.courseDAO.createCourse(courses);
    }

    @Override
    @Transactional
    public void updateCourseById(Courses courses) {
        this.courseDAO.updateCourseById(courses);
    }

    @Override
    @Transactional
    public void deleteCourseByIdCourse(Long id) {
        this.courseDAO.deleteCourseByIdCourse(id);
    }

    @Override
    @Transactional
    public Courses getCourseByIdCourse(Long id) {
        return this.courseDAO.getCourseByIdCourse(id);
    }

    @Override
    @Transactional
    public List<Courses> getAllCourses() {
        return this.courseDAO.getAllCourses();
    }

    @Override
    @Transactional
    public List<Courses> findCourseByString(String searchResult) {
        return this.courseDAO.findCourseByString(searchResult);
    }

    @Override
    @Transactional
    public List<Courses> findAllCoursesThatUserNotRegistered(Long id) {
        return this.courseDAO.findAllCoursesThatUserNotRegistered(id);
    }

    @Override
    @Transactional
    public List<Users> getAllUsers() {
        return this.courseDAO.getAllUsers();
    }

    @Override
    @Transactional
    public List<Lecturers> getAllLecturers() {
        return this.courseDAO.getAllLecturers();
    }

    @Override
    @Transactional
    public List<Statuses> getAllStatuses() {
        return this.courseDAO.getAllStatuses();
    }

    @Override
    @Transactional
    public List<Themes> getAllThemes() {
        return this.courseDAO.getAllThemes();
    }
}
