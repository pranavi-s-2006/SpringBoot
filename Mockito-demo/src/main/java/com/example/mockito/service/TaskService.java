package com.example.mockito.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mockito.MockitoDemoApplication;
import com.example.mockito.model.Task;
import com.example.mockito.repository.TaskRepository;

@Service
public class TaskService {
	private final MockitoDemoApplication mockitoDemoApplication;
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository,MockitoDemoApplication mockitoDemoApplication)
	{
		this.taskRepository = taskRepository;
		this.mockitoDemoApplication =  mockitoDemoApplication;
	}
	public Task addTask(Task task)
	{
		if(task.getName() == null || task.getName().isBlank())
		{
			throw new IllegalArgumentException("Task name cannot be empty");
		}
		return taskRepository.save(task);
	}
	public List<Task> getAlltasks()
	{
		return taskRepository.findAll();
	}
	
}