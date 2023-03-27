package com.github.hanyaeger.tutorial.entities.blocks;

public class HealthConfig {
    private String resource;
    private int health;

    public HealthConfig(String resource, int health) {
        this.resource = resource;
        this.health = health;
    }

    public String getResource() {
        return resource;
    }

    public int getHealth() {
        return health;
    }
}
