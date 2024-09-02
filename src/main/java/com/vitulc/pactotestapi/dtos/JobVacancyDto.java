package com.vitulc.pactotestapi.dtos;

import com.vitulc.pactotestapi.entities.JobVacancy;

public class JobVacancyDto {

    private Long id;
    private String title;
    private String description;

    public JobVacancyDto(JobVacancy entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
    }

    public JobVacancyDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public JobVacancyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
