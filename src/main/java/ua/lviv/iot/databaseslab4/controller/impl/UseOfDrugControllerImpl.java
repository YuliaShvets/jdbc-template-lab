package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.UseOfDrugController;
import ua.lviv.iot.databaseslab4.domain.UseOfDrug;
import ua.lviv.iot.databaseslab4.service.UseOfDrugService;

import java.util.List;
import java.util.Optional;

@Service
public class UseOfDrugControllerImpl implements UseOfDrugController {
    @Autowired
    private UseOfDrugService useOfDrugService;

    @Override
    public List<UseOfDrug> findAll() {
        return useOfDrugService.findAll();
    }

    @Override
    public Optional<UseOfDrug> findById(Integer id) {
        return useOfDrugService.findById(id);
    }

    @Override
    public int create(UseOfDrug useOfDrug) {
        return useOfDrugService.create(useOfDrug);
    }

    @Override
    public int update(Integer id, UseOfDrug useOfDrug) {
        return useOfDrugService.update(id, useOfDrug);
    }

    @Override
    public int delete(Integer id) {
        return useOfDrugService.delete(id);
    }
}
