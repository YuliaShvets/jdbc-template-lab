package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CategoryOfDrugDao;
import ua.lviv.iot.databaseslab4.domain.CategoryOfDrug;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CategoryOfDrugDaoImpl implements CategoryOfDrugDao {

    private static final String FIND_ALL = "SELECT * FROM category_of_drug";
    private static final String CREATE = "INSERT category_of_drug(required_prescription,type,drud_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE category_of_drug SET required_prescription=?, type=?, drug_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM category_of_drug WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM category_of_drug WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryOfDrug> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(CategoryOfDrug.class));
    }

    @Override
    public Optional<CategoryOfDrug> findById(Integer id) {
        Optional<CategoryOfDrug> categoryOfDrug;
        try {
            categoryOfDrug = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(CategoryOfDrug.class), id));
        } catch (EmptyResultDataAccessException e) {
            categoryOfDrug = Optional.empty();
        }
        return categoryOfDrug;
    }

    @Override
    public int create(CategoryOfDrug categoryOfDrug) {
        return jdbcTemplate.update(CREATE, categoryOfDrug.isRequiredPrescription(), categoryOfDrug.getType(), categoryOfDrug.getDrugId());
    }

    @Override
    public int update(Integer id, CategoryOfDrug categoryOfDrug) {
        return jdbcTemplate.update(UPDATE, categoryOfDrug.isRequiredPrescription(), categoryOfDrug.getType(), categoryOfDrug.getDrugId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
