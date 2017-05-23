package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.Lecturers;
import ua.kurson.coursesmanager.model.Users;
import ua.kurson.coursesmanager.model.view.LecturerView;
import ua.kurson.coursesmanager.model.view.MarksView;

public interface LecturerDAO {
    public List<Lecturers> getAllLecturers();

    public int createLecturer(Lecturers lecturers);

    public void changeLecturer(Long id, int idCourse);

    public List<Lecturers> findLecturersByString(String search);

    public void updateLecturer(Lecturers lecturers);

    List<LecturerView> findNotMarkedStudentsOnCourseByLecturersId(Long idLecturer);

    List<MarksView> findMarkedStudentsOnCourseByLecturersId(Long idLecturer);

    public Users findUserByLogin(String login);

    List<Users> getAllUsers();
}
