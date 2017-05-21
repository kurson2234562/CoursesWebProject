package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.StudentOnCourseDAO;
import ua.kurson.coursesmanager.model.StudentCourse;
import ua.kurson.coursesmanager.service.StudentOnCourseService;

@Service
public class StudentOnCourseServiceImpl implements StudentOnCourseService {
    private StudentOnCourseDAO studentOnCourseDAO;

    public void setStudentOnCourseDAO(StudentOnCourseDAO studentOnCourseDAO) {
        this.studentOnCourseDAO = studentOnCourseDAO;
    }

    @Override
    @Transactional
    public List<StudentCourse> getAllStudentsOnCourse() {
        return this.studentOnCourseDAO.getAllStudentsOnCourse();
    }

    @Override
    @Transactional
    public List<StudentCourse> getCountStudentPerCourse() {
        return this.studentOnCourseDAO.getCountStudentPerCourse();
    }

    @Override
    @Transactional
    public void createMarkForStudent(int mark, Long studentId) {
        this.studentOnCourseDAO.createMarkForStudent(mark, studentId);
    }
}
