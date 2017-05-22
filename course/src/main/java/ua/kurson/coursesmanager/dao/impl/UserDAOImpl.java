package ua.kurson.coursesmanager.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ua.kurson.coursesmanager.dao.UserDAO;
import ua.kurson.coursesmanager.model.*;
import ua.kurson.coursesmanager.model.view.JournalView;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void lockUserById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Users> allUsers = getAllUsers();
        for (Users userOnList : allUsers) {
            if (userOnList.getIdUser()==id) {
                if (userOnList.getStatesByIdState().getIdState()==1){
                    States statesByIdState = userOnList.getStatesByIdState();
                    statesByIdState.setIdState(0L);
                    userOnList.setStatesByIdState(statesByIdState);
                }else {
                    States statesByIdState = userOnList.getStatesByIdState();
                    statesByIdState.setIdState(1L);
                    userOnList.setStatesByIdState(statesByIdState);
                }
            }
        }
    }

    @Override
    public Users findUserByLogin(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Users> allUsers = getAllUsers();
        for (Users userOnList : allUsers) {
            if (userOnList.getLogin().equals(login)) {
                return userOnList;
            }
        }
        return null;
    }

    @Override
    public Users getUserById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Users user = (Users) session.load(Users.class, id);

        return user;
    }

    @Override
    public Users createUser(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Users users = (Users) session.load(Users.class, new Long(id));
        if (users != null) {
            session.delete(users);
        }
        logger.info("User successfully deleted. Course details: " + users);
    }

    @Override
    public void registerUserOnCourse(Long id, Long idCourse) {
        //ToDO
    }

    @Override
    public void setNewPassword(Long id, String password) {
        //ToDO
    }

    @Override
    public List<JournalView> getStudentsMarkById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from JournalView where student.id=" + id).list();
    }

    @Override
    public List<Users> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Users").list();
    }

    @Override
    public List<Courses> getAllCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Courses").list();
    }

    @Override
    public List<Roles> getAllRoles() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Roles").list();
    }

    @Override
    public List<Lecturers> getAllLecturers() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Lecturers ").list();
    }

    @Override
    public List<Statuses> getAllStatuses() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Statuses ").list();
    }

    @Override
    public List<Themes> getAllThemes() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Themes").list();
    }
}
