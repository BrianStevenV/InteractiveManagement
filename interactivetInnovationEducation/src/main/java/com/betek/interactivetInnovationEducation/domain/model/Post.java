package com.betek.interactivetInnovationEducation.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Post {
    private Long id;
    private ArrayList<String> media;
    private String caption;
    private String description;
    private ArrayList<Long> likes;
    private ArrayList<Long> comments;
    private Long topic;
    private LocalDate created_at;
    private Long idUser;

    public Post(Long id, ArrayList<String> media, String caption, String description, ArrayList<Long> likes, ArrayList<Long> comments, Long topic, LocalDate created_at, Long idUser) {
        this.id = id;
        this.media = media;
        this.caption = caption;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
        this.topic = topic;
        this.created_at = created_at;
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<String> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<String> media) {
        this.media = media;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Long> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Long> likes) {
        this.likes = likes;
    }

    public ArrayList<Long> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Long> comments) {
        this.comments = comments;
    }

    public Long getTopic() {
        return topic;
    }

    public void setTopic(Long topic) {
        this.topic = topic;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
