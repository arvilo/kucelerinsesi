package az.edu.turing.hackaton.kucelerinsesi.dao;

import java.io.IOException;
import java.util.List;

public interface DAO<T> {
    void insert(T entity) throws IOException;

    T selectById(Long id);

    List<T> search(String keyword);

    void update(T entity) throws IOException;

    void delete(Long id) throws IOException;
}
