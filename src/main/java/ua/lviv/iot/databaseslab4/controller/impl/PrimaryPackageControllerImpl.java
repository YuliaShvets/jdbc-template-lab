package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.PrimaryPackageController;
import ua.lviv.iot.databaseslab4.domain.PrimaryPackage;
import ua.lviv.iot.databaseslab4.service.PrimaryPackageService;

import java.util.List;
import java.util.Optional;

@Service
public class PrimaryPackageControllerImpl implements PrimaryPackageController {
    @Autowired
    private PrimaryPackageService primaryPackageService;

    @Override
    public List<PrimaryPackage> findAll() {
        return primaryPackageService.findAll();
    }

    @Override
    public Optional<PrimaryPackage> findById(Integer id) {
        return primaryPackageService.findById(id);
    }

    @Override
    public int create(PrimaryPackage primaryPackage) {
        return primaryPackageService.create(primaryPackage);
    }

    @Override
    public int update(Integer id, PrimaryPackage primaryPackage) {
        return primaryPackageService.update(id, primaryPackage);
    }

    @Override
    public int delete(Integer id) {
        return primaryPackageService.delete(id);
    }
}
