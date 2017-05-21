package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.AdminDAO;
import ua.kurson.coursesmanager.model.Admins;
import ua.kurson.coursesmanager.model.Courses;

@Repository
public class AdminsDAOImpl implements AdminDAO {

    private static final Logger logger = LoggerFactory.getLogger(AdminsDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Courses> getAllCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Courses> coursesList = session.createQuery("from Courses").list();
        for (Courses courses : coursesList) {
            logger.info("Course list: " + courses);
        }
        return coursesList;
    }

    @Override
    public void updateAdminById(Admins admins) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(admins);
        logger.info("Admin successfully update. Admin details: " + admins);
    }

    @Override
    public String selectTopMark() {
        //ToDO
        return null;
    }

    @Override
    public String selectAvgMark() {
        //ToDO
        return null;
    }
}
