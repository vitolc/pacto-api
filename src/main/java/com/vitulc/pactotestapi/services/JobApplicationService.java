package com.vitulc.pactotestapi.services;

import com.vitulc.pactotestapi.dtos.ApplyVacancyDto;
import com.vitulc.pactotestapi.entities.JobApplication;
import com.vitulc.pactotestapi.repositories.JobApplicationRepository;
import com.vitulc.pactotestapi.utilities.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobVacancyService jobVacancyService;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, JobVacancyService jobVacancyService) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobVacancyService = jobVacancyService;
    }

    public JobApplication save(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplication apply(Long vacancyId, ApplyVacancyDto applyVacancyDto) {
       return save(new JobApplication(jobVacancyService.findById(vacancyId), Utils.loggedUser(), applyVacancyDto.getCoverLetter(), applyVacancyDto.getPhone(), applyVacancyDto.getEmail()));
    }

    public Page<JobApplication> getAllApplications(Long vacancyId, int page, int itemsPerPage, Sort.Direction sortDirection) {
        return jobApplicationRepository.findAllApplicationsByVacancyId(vacancyId, PageRequest.of(page, itemsPerPage, Sort.by(sortDirection, "id")));
    }

    public Page<JobApplication> getAllUserJobApplications(int page, int itemsPerPage, Sort.Direction sortDirection) {
        return jobApplicationRepository.findAllApplicationsByUser(Utils.loggedUser().getId(), PageRequest.of(page, itemsPerPage, Sort.by(sortDirection, "id")));
    }
}
