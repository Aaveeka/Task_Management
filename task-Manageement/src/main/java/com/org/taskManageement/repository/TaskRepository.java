package com.org.taskManageement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.taskManageement.dto.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
