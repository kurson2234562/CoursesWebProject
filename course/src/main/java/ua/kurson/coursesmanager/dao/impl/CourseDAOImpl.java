package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.CourseDAO;
import ua.kurson.coursesmanager.model.*;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createCourse(Courses courses) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(courses);
        logger.info("Course successfully saved. Course details:" + courses);
    }

    @Override
    public void updateCourseById(Courses courses) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(courses);
        logger.info("Course successfully update. Course details:" + courses);
    }

    @Override
    public void deleteCourseByIdCourse(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Courses courses = (Courses) session.load(Courses.class, new Long(id));
        if (courses != null) {
            session.delete(courses);
        }
        logger.info("Course successfully deleted. Course details: " + courses);

    }

    @Override
    public Courses getCourseByIdCourse(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Courses courses = (Courses) session.load(Courses.class, new Long(id));
        logger.info("Course successfully loaded. Course details: " + courses);
        return courses;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Courses> getAllCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Courses> coursesList = session.createQuery("from Courses").list();
        for (Courses courses : coursesList){
            logger.info("Course list: " + courses);
        }
        return coursesList;
    }

    @Override
    public List<Courses> findCourseByString(String searchResult) {
        //ToDo
        return null;
    }

    @Override
    public List<Courses> findAllCoursesThatUserNotRegistered(Long id) {
        //ToDo
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Users> users = session.createQuery("from Users").list();
        for (Users user : users) {
            logger.info("Course list: " + user);
        }
        return users;
    }

    @Override
    public List<Lecturers> getAllLecturers(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Lecturers").list();
    }

    @Override
    public List<Statuses> getAllStatuses(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Statuses").list();
    }

    @Override
    public List<Themes> getAllThemes(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Themes").list();
    }

    @Override
    public String toString() {
        return "CourseDAOImpl{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }
}
