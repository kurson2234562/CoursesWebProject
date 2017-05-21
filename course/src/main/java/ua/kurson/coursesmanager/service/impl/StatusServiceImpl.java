package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.StatusDAO;
import ua.kurson.coursesmanager.model.Statuses;
import ua.kurson.coursesmanager.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusDAO statusDAO;

    public void setStatusDAO(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    @Override
    @Transactional
    public List<Statuses> getAllStatuses() {
        return this.statusDAO.getAllStatuses();
    }
}
