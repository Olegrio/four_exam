package com.fourtexams.dao;

import com.fourtexams.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MountainDao {
    private EntityManager manager;

    public MountainDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Mountain> getAll() {
        TypedQuery<Mountain> query = manager.createNamedQuery("mountain.get_all",Mountain.class);
        List<Mountain> mountain =query.getResultList();
        return mountain;
    }

    public List<Mountain> getMountainRangeOfHeight(int minHeight, int maxHeight) {
        TypedQuery<Mountain> query = manager.createNamedQuery("mountain.range_of_height", Mountain.class);
        query.setParameter("min_height", minHeight);
        query.setParameter("max_height", maxHeight);
        return query.getResultList();
    }

    public List<Mountain> getByName(String name) {
        TypedQuery<Mountain> query = manager.createNamedQuery("mountain.get_by_name", Mountain.class);
        query.setParameter("mountain_name", name);
        return query.getResultList();
    }



    public void update(Mountain entity) {
        manager.merge(entity);
    }

    public void add(Mountain entity) {
        manager.persist(entity);
    }
}
