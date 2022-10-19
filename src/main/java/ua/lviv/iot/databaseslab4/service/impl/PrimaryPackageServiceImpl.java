package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.PrimaryPackageDao;
import ua.lviv.iot.databaseslab4.domain.PrimaryPackage;
import ua.lviv.iot.databaseslab4.service.PrimaryPackageService;

import java.util.List;
import java.util.Optional;


@Service
public class PrimaryPackageServiceImpl implements PrimaryPackageService {
    @Autowired
    private PrimaryPackageDao primaryPackageDao;

    @Override
    public List<PrimaryPackage> findAll() {
        return primaryPackageDao.findAll();
    }

    @Override
    public Optional<PrimaryPackage> findById(Integer id) {
        return primaryPackageDao.findById(id);
    }

    @Override
    public int create(PrimaryPackage primaryPackage) {
        return primaryPackageDao.create(primaryPackage);
    }

    @Override
    public int update(Integer id, PrimaryPackage primaryPackage) {
        return primaryPackageDao.update(id, primaryPackage);
    }

    @Override
    public int delete(Integer id) {
        return primaryPackageDao.delete(id);
    }
}
