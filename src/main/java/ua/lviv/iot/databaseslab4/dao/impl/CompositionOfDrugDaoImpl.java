package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.CompositionOfDrugDao;
import ua.lviv.iot.databaseslab4.domain.CompositionOfDrug;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CompositionOfDrugDaoImpl implements CompositionOfDrugDao {

    private static final String FIND_ALL = "SELECT * FROM composition_of_drug";
    private static final String CREATE = "INSERT composition_of_drug(active_ingredients, drud_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE composition_of_drug SET active_ingredients=?, drug_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM composition_of_drug WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM composition_of_drug WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CompositionOfDrug> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(CompositionOfDrug.class));
    }

    @Override
    public Optional<CompositionOfDrug> findById(Integer id) {
        Optional<CompositionOfDrug> compositionOfDrug;
        try {
            compositionOfDrug = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(CompositionOfDrug.class), id));
        } catch (EmptyResultDataAccessException e) {
            compositionOfDrug = Optional.empty();
        }
        return compositionOfDrug;
    }

    @Override
    public int create(CompositionOfDrug compositionOfDrug) {
        return jdbcTemplate.update(CREATE, compositionOfDrug.getActiveIngredients(), compositionOfDrug.getDrugId());
    }

    @Override
    public int update(Integer id, CompositionOfDrug compositionOfDrug) {
        return jdbcTemplate.update(UPDATE, compositionOfDrug.getActiveIngredients(), compositionOfDrug.getDrugId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
