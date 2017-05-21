package ua.kurson.coursesmanager.service;

import java.util.List;

import ua.kurson.coursesmanager.model.Admins;
import ua.kurson.coursesmanager.model.Courses;

public interface AdminService {
    public void updateAdminById(Admins admins);

    public String selectTopMark();

    public String selectAvgMark();

    public List<Courses> getAllCourses();
}
