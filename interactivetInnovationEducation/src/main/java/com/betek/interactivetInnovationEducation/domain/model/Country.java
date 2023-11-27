package com.betek.interactivetInnovationEducation.domain.model;

public class Country {
    private Long id;
    private String name;
    private String prefix;

    public Country(Long id, String name, String prefix) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
