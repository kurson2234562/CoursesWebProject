package ua.kurson.coursesmanager.service;

import java.util.List;

import ua.kurson.coursesmanager.model.Lecturers;
import ua.kurson.coursesmanager.model.Users;
import ua.kurson.coursesmanager.model.view.LecturerView;
import ua.kurson.coursesmanager.model.view.MarksView;

public interface LecturerService {
    public List<Lecturers> getAllLecturers();

    public int createLecturer(Lecturers lecturers);

    public void changeLecturer(Long id, int idCourse);

    public List<Lecturers> findLecturersByString(String search);

    public void updateLecturer(Lecturers lecturers);

    public List<LecturerView> findNotMarkedStudentsOnCourseByLecturersId(Long idLecturer);

    public List<MarksView> findMarkedStudentsOnCourseByLecturersId(Long idLecturer);

    public Users findUserByLogin(String login);

}
