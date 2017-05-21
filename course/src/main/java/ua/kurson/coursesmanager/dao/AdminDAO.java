package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.Admins;
import ua.kurson.coursesmanager.model.Courses;

public interface AdminDAO {
    public void updateAdminById(Admins admins);

    public String selectTopMark();

    public String selectAvgMark();

    public List<Courses> getAllCourses();

}
