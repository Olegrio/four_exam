package com.fourtexams.dao;

import com.fourtexams.entity.ClimbingGroup;
import com.fourtexams.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClimbingGroupDao {
    private EntityManager manager;

    public List<ClimbingGroup> getGroupsNoStart() {
        TypedQuery<ClimbingGroup> query = manager.createNamedQuery("climbing_groups.get_no_start", ClimbingGroup.class);
        List<ClimbingGroup> groups =query.getResultList();
        return groups;
    }

    public ClimbingGroupDao(EntityManager manager) {
        this.manager = manager;
    }

    public void update(ClimbingGroup entity) {
        manager.merge(entity);
    }

    public void add(ClimbingGroup entity) {
        manager.persist(entity);
    }

}
