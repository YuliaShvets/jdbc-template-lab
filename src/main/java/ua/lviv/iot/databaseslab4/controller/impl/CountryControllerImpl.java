package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.CountryController;
import ua.lviv.iot.databaseslab4.domain.Country;
import ua.lviv.iot.databaseslab4.service.CountryService;

import java.util.List;
import java.util.Optional;


@Service
public class CountryControllerImpl implements CountryController {
    @Autowired
    private CountryService countryService;

    @Override
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public Optional<Country> findById(String name) {
        return countryService.findById(name);
    }

    @Override
    public int create(Country country) {
        return countryService.create(country);
    }

    @Override
    public int update(String name, Country country) {
        return countryService.update(name, country);
    }

    @Override
    public int delete(String name) {
        return countryService.delete(name);
    }
}
