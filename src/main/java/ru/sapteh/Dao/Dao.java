package ru.sapteh.Dao;

import java.util.List;

public interface Dao<Entity,Key> {
    List<Entity> findByAll();
    Entity findById (Key key);
    void create (Entity entity);
    void update (Entity entity);
    void delete (Entity entity);
}
