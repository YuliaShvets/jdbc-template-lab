package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.CompositionOfDrugController;;
import ua.lviv.iot.databaseslab4.domain.CompositionOfDrug;
import ua.lviv.iot.databaseslab4.service.CompositionOfDrugService;

import java.util.List;
import java.util.Optional;

@Service
public class CompositionOfDrugControllerImpl implements CompositionOfDrugController {
    @Autowired
    private CompositionOfDrugService compositionOfDrugService;

    @Override
    public List<CompositionOfDrug> findAll() {
        return compositionOfDrugService.findAll();
    }

    @Override
    public Optional<CompositionOfDrug> findById(Integer id) {
        return compositionOfDrugService.findById(id);
    }

    @Override
    public int create(CompositionOfDrug compositionOfDrug) {
        return compositionOfDrugService.create(compositionOfDrug);
    }

    @Override
    public int update(Integer id, CompositionOfDrug compositionOfDrug) {
        return compositionOfDrugService.update(id, compositionOfDrug);
    }

    @Override
    public int delete(Integer id) {
        return compositionOfDrugService.delete(id);
    }
}

