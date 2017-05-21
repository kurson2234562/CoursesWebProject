package ua.kurson.coursesmanager.dao;

import java.util.List;

import ua.kurson.coursesmanager.model.Statuses;

public interface StatusDAO {
    public List<Statuses> getAllStatuses();
}
