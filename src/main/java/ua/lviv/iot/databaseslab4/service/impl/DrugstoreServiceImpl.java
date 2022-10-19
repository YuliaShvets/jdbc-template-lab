package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.DrugstoreDao;
import ua.lviv.iot.databaseslab4.domain.Drugstore;
import ua.lviv.iot.databaseslab4.service.DrugstoreService;

import java.util.List;
import java.util.Optional;

@Service
public class DrugstoreServiceImpl implements DrugstoreService {
    @Autowired
    private DrugstoreDao drugstoreDao;

    @Override
    public List<Drugstore> findAll() {
        return drugstoreDao.findAll();
    }

    @Override
    public Optional<Drugstore> findById(Integer id) {
        return drugstoreDao.findById(id);
    }

    @Override
    public int create(Drugstore drugstore) {
        return drugstoreDao.create(drugstore);
    }

    @Override
    public int update(Integer id, Drugstore drugstore) {
        return drugstoreDao.update(id, drugstore);
    }

    @Override
    public int delete(Integer id) {
        return drugstoreDao.delete(id);
    }
}
