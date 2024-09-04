package com.test.RestApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "api")
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String url;

    public Api() {
    }

    public Api(String name, String description, String image, String url) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.url = url;
    }
    public Api(Long id, String name, String description, String image, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.url = url;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
