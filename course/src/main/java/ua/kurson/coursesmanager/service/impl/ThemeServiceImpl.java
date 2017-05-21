package ua.kurson.coursesmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.ThemeDAO;
import ua.kurson.coursesmanager.model.Themes;
import ua.kurson.coursesmanager.service.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService {

    private ThemeDAO themeDAO;

    public void setThemeDAO(ThemeDAO themeDAO) {
        this.themeDAO = themeDAO;
    }

    @Override
    @Transactional
    public List<Themes> getAllThemes() {
        return this.themeDAO.getAllThemes();
    }
}
