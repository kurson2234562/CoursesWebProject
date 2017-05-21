package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.kurson.coursesmanager.dao.StudentOnCourseDAO;
import ua.kurson.coursesmanager.model.StudentCourse;

public class StudentOnCourseDAOImpl implements StudentOnCourseDAO {

    private static final Logger logger = LoggerFactory.getLogger(StudentOnCourseDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<StudentCourse> getAllStudentsOnCourse() {
        Session session = this.sessionFactory.getCurrentSession();
        List<StudentCourse> studentsList = session.createQuery("from StudentCourse ").list();

        for (StudentCourse student : studentsList) {
            logger.info("Student list: " + student);
        }

        return studentsList;
    }

    @Override
    public List<StudentCourse> getCountStudentPerCourse() {
        //ToDo
        return null;
    }

    @Override
    public void createMarkForStudent(int mark, Long studentId) {

    }
}
