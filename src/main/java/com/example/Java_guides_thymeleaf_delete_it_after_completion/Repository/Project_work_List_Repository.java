package com.example.Java_guides_thymeleaf_delete_it_after_completion.Repository;

import com.example.Java_guides_thymeleaf_delete_it_after_completion.model.Project_work_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface Project_work_List_Repository extends JpaRepository<Project_work_list,Integer> {

//    @Query("SELECT p FROM Project_work_list p WHERE p.createdAt >= :startTime AND p.createdAt <= :endTime")
//    List<Project_work_list> findAllByCreatedAtBetween(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);


    List<Project_work_list> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
