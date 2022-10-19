package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CategoryOfDrugDao;
import ua.lviv.iot.databaseslab4.domain.CategoryOfDrug;
import ua.lviv.iot.databaseslab4.service.CategoryOfDrugService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryOfDrugServiceImpl implements CategoryOfDrugService {

    @Autowired
    private CategoryOfDrugDao categoryOfDrugDao;

    @Override
    public List<CategoryOfDrug> findAll() {
        return categoryOfDrugDao.findAll();
    }

    @Override
    public Optional<CategoryOfDrug> findById(Integer id) {
        return categoryOfDrugDao.findById(id);
    }

    @Override
    public int create(CategoryOfDrug categoryOfDrug) {
        return categoryOfDrugDao.create(categoryOfDrug);
    }

    @Override
    public int update(Integer id, CategoryOfDrug categoryOfDrug) {
        return categoryOfDrugDao.update(id, categoryOfDrug);
    }

    @Override
    public int delete(Integer id) {
        return categoryOfDrugDao.delete(id);
    }

}
