package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.ProducerController;
import ua.lviv.iot.databaseslab4.domain.Producer;
import ua.lviv.iot.databaseslab4.service.ProducerService;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerControllerImpl implements ProducerController {
    @Autowired
    private ProducerService producerService;

    @Override
    public List<Producer> findAll() {
        return producerService.findAll();
    }

    @Override
    public Optional<Producer> findById(Integer id) {
        return producerService.findById(id);
    }

    @Override
    public int create(Producer producer) {
        return producerService.create(producer);
    }

    @Override
    public int update(Integer id, Producer producer) {
        return producerService.update(id, producer);
    }

    @Override
    public int delete(Integer id) {
        return producerService.delete(id);
    }
}
