package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.LecturerDAO;
import ua.kurson.coursesmanager.model.Lecturers;
import ua.kurson.coursesmanager.model.Users;
import ua.kurson.coursesmanager.model.view.LecturerView;
import ua.kurson.coursesmanager.model.view.MarksView;
import ua.kurson.coursesmanager.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {

    private LecturerDAO lecturerDAO;

    public void setLecturerDAO(LecturerDAO lecturerDAO) {
        this.lecturerDAO = lecturerDAO;
    }

    @Override
    @Transactional
    public List<Lecturers> getAllLecturers() {
        return this.lecturerDAO.getAllLecturers();
    }

    @Override
    @Transactional
    public int createLecturer(Lecturers lecturers) {
        return this.lecturerDAO.createLecturer(lecturers);
    }

    @Override
    @Transactional
    public void changeLecturer(Long id, int idCourse) {
        this.lecturerDAO.changeLecturer(id, idCourse);
    }

    @Override
    @Transactional
    public List<Lecturers> findLecturersByString(String search) {
        return this.lecturerDAO.findLecturersByString(search);
    }

    @Override
    @Transactional
    public void updateLecturer(Lecturers lecturers) {
        this.lecturerDAO.updateLecturer(lecturers);
    }

    @Override
    @Transactional
    public List<LecturerView> findNotMarkedStudentsOnCourseByLecturersId(Long idLecturer) {
        return this.lecturerDAO.findNotMarkedStudentsOnCourseByLecturersId(idLecturer);
    }

    @Override
    @Transactional
    public List<MarksView> findMarkedStudentsOnCourseByLecturersId(Long idLecturer) {
        return this.lecturerDAO.findMarkedStudentsOnCourseByLecturersId(idLecturer);
    }

    @Override
    @Transactional
    public Users findUserByLogin(String login) {
        return this.lecturerDAO.findUserByLogin(login);
    }
}
