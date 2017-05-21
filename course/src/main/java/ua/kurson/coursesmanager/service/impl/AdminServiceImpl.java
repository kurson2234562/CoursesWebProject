package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.AdminDAO;
import ua.kurson.coursesmanager.model.Admins;
import ua.kurson.coursesmanager.model.Courses;
import ua.kurson.coursesmanager.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO;

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    @Transactional
    public void updateAdminById(Admins admins) {
        this.adminDAO.updateAdminById(admins);
    }

    @Override
    @Transactional
    public String selectTopMark() {
        return this.adminDAO.selectTopMark();
    }

    @Override
    @Transactional
    public String selectAvgMark() {
        return this.adminDAO.selectAvgMark();
    }

    @Override
    @Transactional
    public List<Courses> getAllCourses() {
        return this.adminDAO.getAllCourses();
    }
}
