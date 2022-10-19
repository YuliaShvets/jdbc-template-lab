package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.DrugstoreController;
import ua.lviv.iot.databaseslab4.domain.Drugstore;
import ua.lviv.iot.databaseslab4.service.DrugstoreService;

import java.util.List;
import java.util.Optional;

@Service
public class DrugstoreControllerImpl implements DrugstoreController {
    @Autowired
    private DrugstoreService drugstoreService;

    @Override
    public List<Drugstore> findAll() {
        return drugstoreService.findAll();
    }

    @Override
    public Optional<Drugstore> findById(Integer id) {
        return drugstoreService.findById(id);
    }

    @Override
    public int create(Drugstore drugstore) {
        return drugstoreService.create(drugstore);
    }

    @Override
    public int update(Integer id, Drugstore drugstore) {
        return drugstoreService.update(id, drugstore);
    }

    @Override
    public int delete(Integer id) {
        return drugstoreService.delete(id);
    }
}
