package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.DrugstoreDao;
import ua.lviv.iot.databaseslab4.domain.Drugstore;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class DrugstoreDaoImpl implements DrugstoreDao {
    private static final String FIND_ALL = "SELECT * FROM drugstore";
    private static final String CREATE = "INSERT drugstore(name) VALUES (?)";
    private static final String UPDATE = "UPDATE drugstore SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM drugstore WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM drugstore WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Drugstore> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Drugstore.class));
    }

    @Override
    public Optional<Drugstore> findById(Integer id) {
        Optional<Drugstore> drugstore;
        try {
            drugstore = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Drugstore.class), id));
        } catch (EmptyResultDataAccessException e) {
            drugstore = Optional.empty();
        }
        return drugstore;
    }

    @Override
    public int create(Drugstore drugstore) {
        return jdbcTemplate.update(CREATE, drugstore.getName());
    }

    @Override
    public int update(Integer id, Drugstore drugstore) {
        return jdbcTemplate.update(UPDATE, drugstore.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
