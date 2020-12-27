package com.example.transactions.service;

import com.example.transactions.dao.MainDAO;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final MainDAO mainDAO;

    public MainService(MainDAO mainDAO) {
        this.mainDAO = mainDAO;
    }

    public Integer getSoundsCount() {
        return mainDAO.getSoundsCount();
    }

    public void addSound() {
        mainDAO.insertSound();
    }

    public void deleteAll() {
        mainDAO.delete();
    }
}
