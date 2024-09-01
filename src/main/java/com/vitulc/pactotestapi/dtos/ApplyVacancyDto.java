package com.vitulc.pactotestapi.dtos;

import com.vitulc.pactotestapi.entities.JobApplication;

public class ApplyVacancyDto{

    private String coverLetter;

    private String phone;

    private String email;

    public ApplyVacancyDto(JobApplication entity) {
        this.coverLetter = entity.getCoverLetter();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
    }

    public ApplyVacancyDto() {
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
