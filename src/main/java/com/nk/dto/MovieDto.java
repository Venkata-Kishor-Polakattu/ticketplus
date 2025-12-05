package com.nk.dto;

import com.nk.enums.Certification;
import com.nk.enums.MovieStatus;

public class MovieDto { //title, language, duration, certification, status, createdBy
    private String title;
    private String language;
    private Integer duration;
    private Certification certification;
    private MovieStatus status;
    private String createdBy;

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public MovieStatus getStatus() {
        return status;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "certification='" + certification + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", status=" + status +
                ", createdBy=" + createdBy +
                '}';
    }
}
