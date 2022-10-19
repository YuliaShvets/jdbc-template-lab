package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CityDao;
import ua.lviv.iot.databaseslab4.domain.City;
import ua.lviv.iot.databaseslab4.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityDao.findById(id);
    }

    @Override
    public int create(City city) {
        return cityDao.create(city);
    }

    @Override
    public int update(Integer id, City city) {
        return cityDao.update(id, city);
    }

    @Override
    public int delete(Integer id) {
        return cityDao.delete(id);
    }
}
