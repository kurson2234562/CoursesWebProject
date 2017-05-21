package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.LecturerDAO;
import ua.kurson.coursesmanager.model.Lecturers;

@Repository
public class LecturerDAOImpl implements LecturerDAO {

    private static final Logger logger = LoggerFactory.getLogger(LecturerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Lecturers> getAllLecturers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lecturers> lecturersList = session.createQuery("from Lecturers ").list();

        for (Lecturers lecturers: lecturersList) {
            logger.info("Lecturers list: " + lecturers);
        }

        return lecturersList;
    }

    @Override
    public int createLecturer(Lecturers lecturers) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(lecturers);
        logger.info("Lecturer successfully saved. Lecturer details: " + lecturers);
        return -1;
    }

    @Override
    public void changeLecturer(Long id, int idCourse) {
        //ToDo
    }

    @Override
    public List<Lecturers> findLecturersByString(String search) {
        //ToDo
        return null;
    }

    @Override
    public void updateLecturer(Lecturers lecturers) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(lecturers);
        logger.info("Lecturer successfully update. Lecturer details: " + lecturers);
    }
}
