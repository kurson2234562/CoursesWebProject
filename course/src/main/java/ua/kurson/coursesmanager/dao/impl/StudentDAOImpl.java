package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.StudentDAO;
import ua.kurson.coursesmanager.model.Journal;
import ua.kurson.coursesmanager.model.Students;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Students> getAllStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Students> studentsList = session.createQuery("from Students").list();

        for (Students student : studentsList) {
            logger.info("Student list: " + student);
        }

        return studentsList;
    }

    @Override
    public List<Students> findStudentsByString(String searchResult) {
        //ToDo
        return null;
    }

    @Override
    public Students findStudentByIdUser(Long id) {
        //ToDo
        return null;
    }

    @Override
    public List<Journal> getStudentMarksById(Long id) {
        String query = "select Journal.idStudentCourse, Journal.mark from Journal inner join StudentCourse ON Journal.idStudentCourse=StudentCourse.idStudentCourse inner join Students on StudentCourse.id=Students.id WHERE Journal.idStudentCourse=?";
        Session session = this.sessionFactory.getCurrentSession();
        List<Journal> list = session.createQuery(query).setString(0, String.valueOf(id)).list();
        return list;
    }

    @Override
    public void updateStudent(Students students) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(students);
        logger.info("Student successfully update. Student details: " + students);
    }
}
