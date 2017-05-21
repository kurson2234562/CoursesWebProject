package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.StudentCourse;

public interface StudentOnCourseDAO {
    public List<StudentCourse> getAllStudentsOnCourse();

    public List<StudentCourse> getCountStudentPerCourse();

    public void createMarkForStudent(int mark, Long studentId);
}
