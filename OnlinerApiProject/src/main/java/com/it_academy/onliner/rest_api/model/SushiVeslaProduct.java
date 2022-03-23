package com.it_academy.onliner.rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SushiVeslaProduct {
    private int id;
    private String key;
    private String name;
    private String full_name;
    private String name_prefix;

    public String getName() {
        return name;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SushiVeslaProduct that = (SushiVeslaProduct) o;
        return id == that.id && Objects.equals(key, that.key) && Objects.equals(name, that.name)
                && Objects.equals(full_name, that.full_name) && Objects.equals(name_prefix, that.name_prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, name, full_name, name_prefix);
    }

    @Override
    public String toString() {
        return "SushiVeslaProduct{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + full_name + '\'' +
                ", namePrefix='" + name_prefix + '\'' +
                '}';
    }
}