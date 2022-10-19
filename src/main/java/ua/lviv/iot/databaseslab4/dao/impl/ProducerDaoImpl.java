package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.ProducerDao;
import ua.lviv.iot.databaseslab4.domain.Producer;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ProducerDaoImpl implements ProducerDao {
    private static final String FIND_ALL = "SELECT * FROM producer";
    private static final String CREATE = "INSERT producer(name, country_name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE producer SET name=?, country_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM producer WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM producer WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Producer> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Producer.class));
    }

    @Override
    public Optional<Producer> findById(Integer id) {
        Optional<Producer> producer;
        try {
            producer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Producer.class), id));
        } catch (EmptyResultDataAccessException e) {
            producer = Optional.empty();
        }
        return producer;
    }

    @Override
    public int create(Producer producer) {
        return jdbcTemplate.update(CREATE, producer.getName(), producer.getCountryName());
    }

    @Override
    public int update(Integer id, Producer producer) {
        return jdbcTemplate.update(UPDATE, producer.getName(), producer.getCountryName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
