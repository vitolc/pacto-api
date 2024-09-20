package com.vitulc.pactotestapi.repositories;

import com.vitulc.pactotestapi.entities.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends PagingAndSortingRepository<JobApplication, Long>, JpaRepository<JobApplication, Long> {

    @Query("""
            SELECT ja FROM JobApplication ja
            WHERE ja.jobVacancy.id = :vacancyId
            """)
    Page<JobApplication> findAllApplicationsByVacancyId(@Param("vacancyId") Long vacancyId, Pageable pageable);

    @Query("""
            SELECT ja FROM JobApplication ja
            WHERE ja.user.id = :userId
            """)
    Page<JobApplication> findAllApplicationsByUser(@Param("userId") Long userId, Pageable pageable);
}
