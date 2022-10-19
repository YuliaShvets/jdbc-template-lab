package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.UseOfDrugDao;
import ua.lviv.iot.databaseslab4.domain.UseOfDrug;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class UseOfDrugDaoImpl implements UseOfDrugDao {
    private static final String FIND_ALL = "SELECT * FROM use_of_drug";
    private static final String CREATE = "INSERT use_of_drug(use_type, drug_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE use_of_drug SET use_type=?, drug_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM use_of_drug WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM use_of_drug WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UseOfDrug> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(UseOfDrug.class));
    }

    @Override
    public Optional<UseOfDrug> findById(Integer id) {
        Optional<UseOfDrug> useOfDrug;
        try {
            useOfDrug = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(UseOfDrug.class), id));
        } catch (EmptyResultDataAccessException e) {
            useOfDrug = Optional.empty();
        }
        return useOfDrug;
    }

    @Override
    public int create(UseOfDrug useOfDrug) {
        return jdbcTemplate.update(CREATE, useOfDrug.getUseType(), useOfDrug.getDrugId());
    }

    @Override
    public int update(Integer id, UseOfDrug useOfDrug) {
        return jdbcTemplate.update(UPDATE,useOfDrug.getUseType(), useOfDrug.getDrugId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
