package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.CategoryOfDrugController;
import ua.lviv.iot.databaseslab4.domain.CategoryOfDrug;
import ua.lviv.iot.databaseslab4.service.CategoryOfDrugService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryOfDrugControllerImpl implements CategoryOfDrugController {
    @Autowired
    private CategoryOfDrugService categoryOfDrugService;

    @Override
    public List<CategoryOfDrug> findAll() {
        return categoryOfDrugService.findAll();
    }

    @Override
    public Optional<CategoryOfDrug> findById(Integer id) {
        return categoryOfDrugService.findById(id);
    }

    @Override
    public int create(CategoryOfDrug categoryOfDrug) {
        return categoryOfDrugService.create(categoryOfDrug);
    }

    @Override
    public int update(Integer id, CategoryOfDrug categoryOfDrug) {
        return categoryOfDrugService.update(id, categoryOfDrug);
    }

    @Override
    public int delete(Integer id) {
        return categoryOfDrugService.delete(id);
    }

}
