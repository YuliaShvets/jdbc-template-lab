package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.UseOfDrugDao;
import ua.lviv.iot.databaseslab4.domain.UseOfDrug;
import ua.lviv.iot.databaseslab4.service.UseOfDrugService;

import java.util.List;
import java.util.Optional;

@Service
public class UseOfDrugServiceImpl implements UseOfDrugService {

    @Autowired
    private UseOfDrugDao useOfDrugDao;

    @Override
    public List<UseOfDrug> findAll() {
        return useOfDrugDao.findAll();
    }

    @Override
    public Optional<UseOfDrug> findById(Integer id) {
        return useOfDrugDao.findById(id);
    }

    @Override
    public int create(UseOfDrug useOfDrug) {
        return useOfDrugDao.create(useOfDrug);
    }

    @Override
    public int update(Integer id, UseOfDrug useOfDrug) {
        return useOfDrugDao.update(id, useOfDrug);
    }

    @Override
    public int delete(Integer id) {
        return useOfDrugDao.delete(id);
    }
}
