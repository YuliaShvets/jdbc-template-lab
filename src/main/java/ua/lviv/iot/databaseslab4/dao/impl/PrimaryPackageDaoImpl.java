package ua.lviv.iot.databaseslab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databaseslab4.dao.PrimaryPackageDao;
import ua.lviv.iot.databaseslab4.domain.PrimaryPackage;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class PrimaryPackageDaoImpl implements PrimaryPackageDao {
    private static final String FIND_ALL = "SELECT * FROM primary_package";
    private static final String CREATE = "INSERT primary_package(type_packaging, drug_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE primary_package SET type_packaging=?, drug_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM primary_package WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM primary_package WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PrimaryPackage> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(PrimaryPackage.class));
    }

    @Override
    public Optional<PrimaryPackage> findById(Integer id) {
        Optional<PrimaryPackage> primaryPackage;
        try {
            primaryPackage = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(PrimaryPackage.class), id));
        } catch (EmptyResultDataAccessException e) {
            primaryPackage = Optional.empty();
        }
        return primaryPackage;
    }

    @Override
    public int create(PrimaryPackage primaryPackage) {
        return jdbcTemplate.update(CREATE, primaryPackage.getTypePackaging(), primaryPackage.getDrugId());
    }

    @Override
    public int update(Integer id, PrimaryPackage  primaryPackage) {
        return jdbcTemplate.update(UPDATE, primaryPackage.getTypePackaging(), primaryPackage.getDrugId() , id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
