package ua.kurson.coursesmanager.service;

import java.util.List;

import ua.kurson.coursesmanager.model.StudentCourse;

public interface StudentOnCourseService {
    public List<StudentCourse> getAllStudentsOnCourse();

    public List<StudentCourse> getCountStudentPerCourse();

    public void createMarkForStudent(int mark, Long studentId);
}
