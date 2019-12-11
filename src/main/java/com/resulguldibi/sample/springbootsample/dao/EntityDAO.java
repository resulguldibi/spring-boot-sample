package com.resulguldibi.sample.springbootsample.dao;

import com.resulguldibi.sample.springbootsample.model.Entity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EntityDAO {

    private static ArrayList<Entity> list = new ArrayList<>();

    static
    {
        list.add(new Entity(1, "resul"));
        list.add(new Entity(2, "özlem"));
        list.add(new Entity(3, "bihter"));
    }

    public ArrayList<Entity> getEntities()
    {
        return list;
    }

    public void addEntity(Entity entity) {
        list.add(entity);
    }

}
