package com.vitulc.pactotestapi.controllers;

import com.vitulc.pactotestapi.common.ResponseResult;
import com.vitulc.pactotestapi.common.ResultPageDto;
import com.vitulc.pactotestapi.dtos.ApplyVacancyDto;
import com.vitulc.pactotestapi.dtos.JobApplicationsDto;
import com.vitulc.pactotestapi.dtos.JobVacancyDto;
import com.vitulc.pactotestapi.dtos.UserDto;
import com.vitulc.pactotestapi.entities.JobApplication;
import com.vitulc.pactotestapi.routes.Routes;
import com.vitulc.pactotestapi.services.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(Routes.Dashboard.JobApplication.path)
    public ResponseResult<ResultPageDto<JobApplication, JobApplicationsDto>> getAllJobVacanciesPaginated(
            @PathVariable Long vacancyId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int itemsPerPage,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection) {

        Page<JobApplication> jobApplicationPage = jobApplicationService.getAllApplications(vacancyId, page, itemsPerPage, sortDirection);

        List<JobApplicationsDto> jobApplicationDtos = jobApplicationPage.getContent().stream()
                .map(application -> {
                    UserDto userDto = new UserDto(application.getUser());
                    JobVacancyDto jobVacancyDto = new JobVacancyDto(application.getJobVacancy());
                    return new JobApplicationsDto(userDto, jobVacancyDto, application.getCoverLetter(), application.getPhone(), application.getEmail());
                })
                .collect(Collectors.toList());

        ResultPageDto<JobApplication, JobApplicationsDto> resultPageDto = ResultPageDto.of(
                jobApplicationPage.getTotalElements(),
                jobApplicationPage.getTotalPages(),
                jobApplicationPage.getNumber(),
                jobApplicationDtos
        );

        return ResponseResult.success(resultPageDto);
    }
}
