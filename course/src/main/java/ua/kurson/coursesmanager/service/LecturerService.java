package ua.kurson.coursesmanager.service;

import java.util.List;

import ua.kurson.coursesmanager.model.Lecturers;

public interface LecturerService {
    public List<Lecturers> getAllLecturers();

    public int createLecturer(Lecturers lecturers);

    public void changeLecturer(Long id, int idCourse);

    public List<Lecturers> findLecturersByString(String search);

    public void updateLecturer(Lecturers lecturers);
}
