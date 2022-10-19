package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.DrugController;
import ua.lviv.iot.databaseslab4.domain.Drug;
import ua.lviv.iot.databaseslab4.service.DrugService;

import java.util.List;
import java.util.Optional;

@Service
public class DrugControllerImpl implements DrugController {
    @Autowired
    private DrugService drugService;

    @Override
    public List<Drug> findAll() {
        return drugService.findAll();
    }

    @Override
    public Optional<Drug> findById(Integer id) {
        return drugService.findById(id);
    }

    @Override
    public int create(Drug drug) {
        return drugService.create(drug);
    }

    @Override
    public int update(Integer id, Drug drug) {
        return drugService.update(id, drug);
    }

    @Override
    public int delete(Integer id) {
        return drugService.delete(id);
    }
}
