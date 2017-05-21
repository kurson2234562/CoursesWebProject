package ua.kurson.coursesmanager.service;

import java.util.List;

import ua.kurson.coursesmanager.model.Journal;
import ua.kurson.coursesmanager.model.Students;

public interface StudentService {
    public List<Students> getAllStudents();

    public List<Students> findStudentsByString(String searchResult);

    public Students findStudentByIdUser(Long id);

    public List<Journal> getStudentMarksById(Long id);

    public void updateStudent(Students students);
}
