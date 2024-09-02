package com.vitulc.pactotestapi.dtos;

public class JobApplicationsDto {

    private UserDto user;

    private JobVacancyDto vacancy;

    private String coverLetter;

    private String phone;

    private String email;

    public JobApplicationsDto(UserDto user, JobVacancyDto jobVacancy, String coverLetter, String phone, String email) {
        this.user = user;
        this.vacancy = jobVacancy;
        this.coverLetter = coverLetter;
        this.phone = phone;
        this.email = email;
    }

    public JobApplicationsDto() {
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public JobVacancyDto getVacancy() {
        return vacancy;
    }

    public void setVacancy(JobVacancyDto vacancy) {
        this.vacancy = vacancy;
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
