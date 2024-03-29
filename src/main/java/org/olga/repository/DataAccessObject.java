package org.olga.repository;

import org.olga.entity.Entity;

import java.sql.Connection;
import java.util.List;

public interface DataAccessObject<T extends Entity> {
   Connection getConnection();

   Connection getDefaultConnection();

    T getById(long id);

    List<T> getAll();

    T create(T t);

    T update(T t);

    boolean delete(long id);
}
