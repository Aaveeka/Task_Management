package com.org.taskManageement.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.taskManageement.cException.ResourceNotFoundExceptions;
import com.org.taskManageement.dto.Task;
import com.org.taskManageement.repository.TaskRepository;

@Component
public class TaskDao {
	
	@Autowired
	TaskRepository taskRepo;

	public Task saveAndUpdateTask(Task task) {
		Task task2 = taskRepo.save(task);

		return task2;
	}

	//find task by id
	public Task fetchTaskItemById(int id) {
		
		Task task = taskRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundExceptions("task is not exist with the given id"+id));
		
		return task;
	}

	//find all tasks
	public List<Task> fetchAllTask() {

		List<Task> list = taskRepo.findAll();
		
		return list.stream().map((task) -> Task.TaskElements(task))
				.collect(Collectors.toList());
	
	}

	
	

	public void deleteTask(int id) {
		Task tasks = taskRepo.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("the task is not exists given id"+id));

		taskRepo.deleteById(id);
		

	}
	
	public Task updateStatusById(int id, Task task) {
		Task existTask2 = taskRepo.findById(id).get();
		
		existTask2.setId(task.getId());
		existTask2.setTname(task.getTname());
		existTask2.setDuedate(task.getDuedate());
		existTask2.setPriority(task.getPriority());
		existTask2.setStatus(task.getStatus());
		
		return taskRepo.save(existTask2);
		
		
		
		


	}

}
