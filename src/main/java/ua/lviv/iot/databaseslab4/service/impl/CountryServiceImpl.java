package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CountryDao;
import ua.lviv.iot.databaseslab4.domain.Country;
import ua.lviv.iot.databaseslab4.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public Optional<Country> findById(String name) {
        return countryDao.findById(name);
    }

    @Override
    public int create(Country country) {
        return countryDao.create(country);
    }

    @Override
    public int update(String name, Country country) {
        return countryDao.update(name, country);
    }

    @Override
    public int delete(String name) {
        return countryDao.delete(name);
    }
}
