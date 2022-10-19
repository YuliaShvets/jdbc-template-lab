package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.DrugDao;
import ua.lviv.iot.databaseslab4.domain.Drug;
import ua.lviv.iot.databaseslab4.service.DrugService;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugDao drugDao;

    @Override
    public List<Drug> findAll() {
        return drugDao.findAll();
    }

    @Override
    public Optional<Drug> findById(Integer id) {
        return drugDao.findById(id);
    }

    @Override
    public int create(Drug drug) {
        return drugDao.create(drug);
    }

    @Override
    public int update(Integer id, Drug drug) {
        return drugDao.update(id, drug);
    }

    @Override
    public int delete(Integer id) {
        return drugDao.delete(id);
    }
}
