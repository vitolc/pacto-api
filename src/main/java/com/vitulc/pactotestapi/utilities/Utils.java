package com.vitulc.pactotestapi.utilities;

import com.vitulc.pactotestapi.common.ResponseResult;
import com.vitulc.pactotestapi.common.ResultPageDto;
import com.vitulc.pactotestapi.config.security.DbUserDetails;
import com.vitulc.pactotestapi.dtos.JobApplicationsDto;
import com.vitulc.pactotestapi.dtos.JobVacancyDto;
import com.vitulc.pactotestapi.dtos.UserDto;
import com.vitulc.pactotestapi.entities.JobApplication;
import com.vitulc.pactotestapi.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static User loggedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        return ((DbUserDetails) authentication.getPrincipal()).getUser();
    }

    private static ResponseResult<ResultPageDto<JobApplication, JobApplicationsDto>> getResultPageDtoResponseResult(Page<JobApplication> jobApplicationPage) {
        return getResultPageDtoResponseResult(jobApplicationPage);
    }
}
