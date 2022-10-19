package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.ProducerDao;
import ua.lviv.iot.databaseslab4.domain.Producer;
import ua.lviv.iot.databaseslab4.service.ProducerService;

import java.util.List;
import java.util.Optional;


@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerDao producerDao;

    @Override
    public List<Producer> findAll() {
        return producerDao.findAll();
    }

    @Override
    public Optional<Producer> findById(Integer id) {
        return producerDao.findById(id);
    }

    @Override
    public int create(Producer producer) {
        return producerDao.create(producer);
    }

    @Override
    public int update(Integer id, Producer producer) {
        return producerDao.update(id, producer);
    }

    @Override
    public int delete(Integer id) {
        return producerDao.delete(id);
    }
}
