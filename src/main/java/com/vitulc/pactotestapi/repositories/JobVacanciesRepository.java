package com.vitulc.pactotestapi.repositories;

import com.vitulc.pactotestapi.entities.JobVacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobVacanciesRepository extends PagingAndSortingRepository<JobVacancy, Long> ,JpaRepository<JobVacancy, Long> {

    @Query("""
            SELECT jv FROM JobVacancy jv 
            WHERE (trim(lower(FUNCTION('unaccent', jv.title))) LIKE trim(lower(FUNCTION('unaccent', CONCAT('%', :q, '%'))))
            OR :q IS NULL OR :q = '') 
            """)
    Page<JobVacancy> findAllJobVacancies(@Param("q") String q, Pageable pageable);
}
