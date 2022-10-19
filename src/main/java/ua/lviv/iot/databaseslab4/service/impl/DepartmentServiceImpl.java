package ua.lviv.iot.databaseslab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CityDao;
import ua.lviv.iot.databaseslab4.dao.DepartmentDao;
import ua.lviv.iot.databaseslab4.domain.City;
import ua.lviv.iot.databaseslab4.domain.Department;
import ua.lviv.iot.databaseslab4.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return departmentDao.findById(id);
    }

    @Override
    public int create(Department department) {
        return departmentDao.create(department);
    }

    @Override
    public int update(Integer id, Department department) {
        return departmentDao.update(id, department);
    }

    @Override
    public int delete(Integer id) {
        return departmentDao.delete(id);
    }
}
