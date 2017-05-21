package ua.kurson.coursesmanager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.JournalDAO;
import ua.kurson.coursesmanager.model.Journal;

@Repository
public class JournalDAOImpl implements JournalDAO {

    private static final Logger logger = LoggerFactory.getLogger(JournalDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void updateJournal(Journal journal) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(journal);
        logger.info("Journal successfully update. Journal details: " + journal);
    }
}
