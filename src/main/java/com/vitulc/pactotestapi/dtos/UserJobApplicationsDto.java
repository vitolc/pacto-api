package com.vitulc.pactotestapi.dtos;

public class UserJobApplicationsDto {

    private Long id;

    private JobVacancyDto vacancy;

    private String coverLetter;

    private String phone;

    private String email;

    public UserJobApplicationsDto(JobVacancyDto jobVacancy, Long id, String coverLetter, String phone, String email) {
        this.vacancy = jobVacancy;
        this.id = id;
        this.coverLetter = coverLetter;
        this.phone = phone;
        this.email = email;
    }

    public UserJobApplicationsDto() {
    }

    public JobVacancyDto getVacancy() {
        return vacancy;
    }

    public void setVacancy(JobVacancyDto vacancy) {
        this.vacancy = vacancy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
