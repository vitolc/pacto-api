package com.vitulc.pactotestapi.services;


import com.vitulc.pactotestapi.dtos.JobVacancyDto;
import com.vitulc.pactotestapi.entities.JobVacancy;
import com.vitulc.pactotestapi.exceptions.errors.NotFoundException;
import com.vitulc.pactotestapi.repositories.JobVacanciesRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class JobVacancyService {

    private final JobVacanciesRepository jobVacanciesRepository;

    public JobVacancyService(JobVacanciesRepository jobVacanciesRepository) {
        this.jobVacanciesRepository = jobVacanciesRepository;
    }

    public JobVacancy save(JobVacancy jobVacancy) {
        return jobVacanciesRepository.save(jobVacancy);
    }

    public JobVacancy findById(Long id) {
        return jobVacanciesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Job Vacancy Not Found"));
    }

    @Transactional
    public JobVacancy create(JobVacancyDto jobVacancyDto) {
        return save(new JobVacancy(jobVacancyDto.getTitle(), jobVacancyDto.getDescription()));
    }

    public Page<JobVacancy> getAllVacancies(String q, int page, int itemsPerPage, Sort.Direction sortDirection) {
        return jobVacanciesRepository.findAllJobVacancies(q, PageRequest.of(page, itemsPerPage, Sort.by(sortDirection, "id")));
    }
}
