package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CompositionOfDrugDao;
import ua.lviv.iot.databaseslab4.domain.CompositionOfDrug;
import ua.lviv.iot.databaseslab4.service.CompositionOfDrugService;

import java.util.List;
import java.util.Optional;

@Service
public class CompositionOfDrugServiceImpl implements CompositionOfDrugService {
    @Autowired
    private CompositionOfDrugDao compositionOfDrugDao;

    @Override
    public List<CompositionOfDrug> findAll() {
        return compositionOfDrugDao.findAll();
    }

    @Override
    public Optional<CompositionOfDrug> findById(Integer id) {
        return compositionOfDrugDao.findById(id);
    }

    @Override
    public int create(CompositionOfDrug compositionOfDrug) {
        return compositionOfDrugDao.create(compositionOfDrug);
    }

    @Override
    public int update(Integer id, CompositionOfDrug compositionOfDrug) {
        return compositionOfDrugDao.update(id, compositionOfDrug);
    }

    @Override
    public int delete(Integer id) {
        return compositionOfDrugDao.delete(id);
    }
}
