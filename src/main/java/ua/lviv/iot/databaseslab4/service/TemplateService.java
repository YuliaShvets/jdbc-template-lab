package ua.lviv.iot.databaseslab4.service;

import java.util.List;
import java.util.Optional;

public interface TemplateService<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
