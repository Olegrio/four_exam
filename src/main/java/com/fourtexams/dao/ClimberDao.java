package com.fourtexams.dao;


import com.fourtexams.entity.Climber;
import com.fourtexams.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClimberDao {
    private EntityManager manager;

    public ClimberDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Climber> getByNameAndEmail(String name, String email) {
        TypedQuery<Climber> query = manager.createNamedQuery("climber.get_by_name_and_email", Climber.class);
        query.setParameter("climber_name", name);
        query.setParameter("climber_email", email);
        return query.getResultList();
    }

    public void update(Climber entity) {
        manager.merge(entity);
    }

    public void add(Climber entity) {
        manager.persist(entity);
    }


}
