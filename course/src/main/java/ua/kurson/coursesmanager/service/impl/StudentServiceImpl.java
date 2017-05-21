package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.StudentDAO;
import ua.kurson.coursesmanager.model.Journal;
import ua.kurson.coursesmanager.model.Students;
import ua.kurson.coursesmanager.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Students> getAllStudents() {
        return this.studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public List<Students> findStudentsByString(String searchResult) {
        return this.studentDAO.findStudentsByString(searchResult);
    }

    @Override
    @Transactional
    public Students findStudentByIdUser(Long id) {
        return this.studentDAO.findStudentByIdUser(id);
    }

    @Override
    @Transactional
    public List<Journal> getStudentMarksById(Long id) {
        return this.studentDAO.getStudentMarksById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Students students) {
        this.studentDAO.updateStudent(students);
    }
}
