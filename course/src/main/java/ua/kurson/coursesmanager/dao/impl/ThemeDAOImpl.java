package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.ThemeDAO;
import ua.kurson.coursesmanager.model.Themes;

@Repository
public class ThemeDAOImpl implements ThemeDAO {
    private static final Logger logger = LoggerFactory.getLogger(ThemeDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Themes> getAllThemes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Themes> themesList = session.createQuery("from Themes ").list();
        for (Themes themes : themesList) {
            logger.info("Themes list: " + themes);
        }
        return themesList;
    }
}
