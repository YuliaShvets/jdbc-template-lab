package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.DepartmentDao;
import ua.lviv.iot.databaseslab4.domain.Department;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class DepartmentDaoImpl implements DepartmentDao {
    private static final String FIND_ALL = "SELECT * FROM department";
    private static final String CREATE = "INSERT department(number, drugstore_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE department SET number=?, drugtore_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM department WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM department WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Department> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Department.class));
    }

    @Override
    public Optional<Department> findById(Integer id) {
        Optional<Department> department;
        try {
            department = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Department.class), id));
        } catch (EmptyResultDataAccessException e) {
            department = Optional.empty();
        }
        return department;
    }

    @Override
    public int create(Department department) {
        return jdbcTemplate.update(CREATE, department.getNumber(), department.getDrugstoreId());
    }

    @Override
    public int update(Integer id, Department department) {
        return jdbcTemplate.update(UPDATE, department.getNumber(), department.getDrugstoreId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
