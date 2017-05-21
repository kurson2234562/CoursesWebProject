package ua.kurson.coursesmanager.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kurson.coursesmanager.dao.JournalDAO;
import ua.kurson.coursesmanager.model.Journal;
import ua.kurson.coursesmanager.service.JournalService;

@Service
public class JournalServiceImpl implements JournalService {

    private JournalDAO journalDAO;

    public void setJournalDAO(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    @Override
    @Transactional
    public void updateJournal(Journal journal) {
        this.journalDAO.updateJournal(journal);
    }
}
