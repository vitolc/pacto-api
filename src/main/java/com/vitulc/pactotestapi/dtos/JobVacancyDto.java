package com.vitulc.pactotestapi.dtos;

import com.vitulc.pactotestapi.entities.JobVacancy;

public class JobVacancyDto {

    private String title;
    private String description;

    public JobVacancyDto(JobVacancy entity) {
        this.title = entity.getTitle();
        this.description = entity.getDescription();
    }

    public JobVacancyDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public JobVacancyDto() {
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
