package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.Lecturers;

public interface LecturerDAO {
    public List<Lecturers> getAllLecturers();

    public int createLecturer(Lecturers lecturers);

    public void changeLecturer(Long id, int idCourse);

    public List<Lecturers> findLecturersByString(String search);

    public void updateLecturer(Lecturers lecturers);
}
