package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T get(int id);

    List<T> getAll();

    void add(T t);

    void update(int id,T t);

    void delete(int id);
}
