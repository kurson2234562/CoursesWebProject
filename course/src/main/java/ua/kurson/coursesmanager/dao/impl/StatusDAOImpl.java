package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.StatusDAO;
import ua.kurson.coursesmanager.model.Statuses;

@Repository
public class StatusDAOImpl implements StatusDAO {

    private static final Logger logger = LoggerFactory.getLogger(StatusDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Statuses> getAllStatuses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Statuses> statusesList = session.createQuery("from Statuses").list();
        for (Statuses statuses: statusesList){
            logger.info("Status list:"+ statuses);
        }
        return statusesList;
    }
}
