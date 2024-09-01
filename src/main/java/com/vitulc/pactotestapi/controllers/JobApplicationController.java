package com.vitulc.pactotestapi.controllers;

import com.vitulc.pactotestapi.common.ResponseResult;
import com.vitulc.pactotestapi.dtos.ApplyVacancyDto;
import com.vitulc.pactotestapi.routes.Routes;
import com.vitulc.pactotestapi.services.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping(Routes.Dashboard.JobVacancy.Apply.path)
    public ResponseResult<ApplyVacancyDto> apply(@RequestParam Long vacancyId, @Valid @RequestBody ApplyVacancyDto applyVacancyDto) {
        return ResponseResult.success(new ApplyVacancyDto(jobApplicationService.apply(vacancyId, applyVacancyDto)));
    }
}
