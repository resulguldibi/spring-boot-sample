package com.resulguldibi.sample.springbootsample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class Entity {

    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    private String name;

    public Entity() {

    }

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
