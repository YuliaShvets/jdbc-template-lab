package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.DrugDao;
import ua.lviv.iot.databaseslab4.domain.City;
import ua.lviv.iot.databaseslab4.domain.Drug;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class DrugDaoImpl implements DrugDao {
    private static final String FIND_ALL = "SELECT * FROM drug";
    private static final String CREATE = "INSERT drug(name, production_date, expiration_date, is_available, price_in_dollars, producer_id, drugstore_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE drug SET name=?, production_date=?, expiratin_date=?, is_available=?, price_in_dollars=?, producer_id=?, drugstore_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM drug WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM drug WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Drug> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Drug.class));
    }

    @Override
    public Optional<Drug> findById(Integer id) {
        Optional<Drug> drug;
        try {
            drug = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Drug.class), id));
        } catch (EmptyResultDataAccessException e) {
            drug = Optional.empty();
        }
        return drug;
    }

    @Override
    public int create(Drug drug) {
        return jdbcTemplate.update(CREATE, drug.getName(), drug.getProductionDate(), drug.getExpirationDate(), drug.isAvailable(), drug.getPriceInDollars(), drug.getProducerId(), drug.getDrugstoreId());
    }

    @Override
    public int update(Integer id, Drug drug) {
        return jdbcTemplate.update(UPDATE, drug.getName(), drug.getProductionDate(), drug.getExpirationDate(), drug.isAvailable(), drug.getPriceInDollars(), drug.getProducerId(), drug.getDrugstoreId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
