package com.vitulc.pactotestapi.services;

import com.vitulc.pactotestapi.dtos.ApplyVacancyDto;
import com.vitulc.pactotestapi.entities.JobApplication;
import com.vitulc.pactotestapi.repositories.JobApplicationRepository;
import com.vitulc.pactotestapi.utilities.Utils;
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

    public JobApplication apply(Long jobId, ApplyVacancyDto applyVacancyDto) {
       return save(new JobApplication(jobVacancyService.findById(jobId), Utils.loggedUser(), applyVacancyDto.getCoverLetter(), applyVacancyDto.getPhone(), applyVacancyDto.getEmail()));
    }
}