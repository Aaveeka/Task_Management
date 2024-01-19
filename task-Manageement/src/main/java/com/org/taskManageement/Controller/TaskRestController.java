package com.org.taskManageement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.taskManageement.dao.TaskDao;
import com.org.taskManageement.dto.Task;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/task")
public class TaskRestController {
	
	@Autowired
	TaskDao dao;
	
	
	@PostMapping
	public ResponseEntity<Task> addTaskItem(@RequestBody Task task) {

		Task tasks2 = dao.saveAndUpdateTask(task);

		return new ResponseEntity<Task>(tasks2, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> findTaskById(@PathVariable int id) {
		
		Task task = dao.fetchTaskItemById(id);
		
		return ResponseEntity.ok(task);
	}

	@GetMapping
	public ResponseEntity<List<Task>> viewAllTasks() {
		List<Task> allTask = dao.fetchAllTask();
		
		return ResponseEntity.ok(allTask);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable int id){
		dao.deleteTask(id);
		
		return ResponseEntity.ok("task deleted Successfully!.");
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Task> updateStatus(@PathVariable int id, @RequestBody Task task ) {
		Task task2 = dao.updateStatusById(id,task);
		
		
		return ResponseEntity.ok(task2);
		
		

	}
	

}
