package com.vitulc.pactotestapi.controllers;

import com.vitulc.pactotestapi.common.ResponseResult;
import com.vitulc.pactotestapi.common.ResultPageDto;
import com.vitulc.pactotestapi.dtos.JobVacancyDto;
import com.vitulc.pactotestapi.entities.JobVacancy;
import com.vitulc.pactotestapi.routes.Routes;
import com.vitulc.pactotestapi.services.JobVacancyService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobVacancyController {

    private final JobVacancyService jobVacancyService;

    public JobVacancyController(JobVacancyService jobVacancyService) {
        this.jobVacancyService = jobVacancyService;
    }

    @PostMapping(Routes.Dashboard.JobVacancy.Create.path)
    public ResponseResult<JobVacancyDto> registerUser(@Valid @RequestBody JobVacancyDto jobVacancyDto) {
        return ResponseResult.success(new JobVacancyDto(jobVacancyService.create(jobVacancyDto)));
    }

    @GetMapping(Routes.Public.JobVacancy.path)
    public ResponseResult<ResultPageDto<JobVacancy, JobVacancyDto>> getAllJobVacanciesPaginated(
            @RequestParam(required = false, defaultValue = "") String q,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int itemsPerPage,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection) {

        Page<JobVacancy> jobVacancyPage = jobVacancyService.getAllVacancies(q, page, itemsPerPage, sortDirection);

        List<JobVacancyDto> jobVacancyDtos = jobVacancyPage.getContent().stream()
                .map(JobVacancyDto::new)
                .collect(Collectors.toList());

        ResultPageDto<JobVacancy, JobVacancyDto> resultPageDto = ResultPageDto.of(
                jobVacancyPage.getTotalElements(),
                jobVacancyPage.getTotalPages(),
                jobVacancyPage.getNumber(),
                jobVacancyDtos
        );

        return ResponseResult.success(resultPageDto);
    }
}
