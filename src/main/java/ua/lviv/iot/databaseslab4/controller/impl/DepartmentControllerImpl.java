package ua.lviv.iot.databaseslab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.controller.DepartmentController;
import ua.lviv.iot.databaseslab4.domain.Department;
import ua.lviv.iot.databaseslab4.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentControllerImpl implements DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return departmentService.findById(id);
    }

    @Override
    public int create(Department department) {
        return departmentService.create(department);
    }

    @Override
    public int update(Integer id, Department department) {
        return departmentService.update(id, department);
    }

    @Override
    public int delete(Integer id) {
        return departmentService.delete(id);
    }
}
