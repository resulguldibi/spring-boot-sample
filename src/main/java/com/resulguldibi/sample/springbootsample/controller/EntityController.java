package com.resulguldibi.sample.springbootsample.controller;

import com.resulguldibi.sample.springbootsample.dao.EntityDAO;
import com.resulguldibi.sample.springbootsample.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

@RestController
public class EntityController {

    @Autowired
    private EntityDAO entityDAO;

    @GetMapping(path = "/entities", produces = "application/json")
    public ArrayList<Entity> getAllEntities() {
        return entityDAO.getEntities();
    }

    @GetMapping(path = "/entities/{id}", produces = "application/json")
    public Entity getEntityById(@PathVariable String id) {
        ArrayList<Entity> list = entityDAO.getEntities();
        Entity entity = null;
        for (Entity e : list) {
            if (String.valueOf(e.getId()).equals(id)) {
                entity = e;
                break;
            }
        }

        return entity;
    }

    @PostMapping(path = "/entities", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Entity entity) {
        entityDAO.addEntity(entity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
