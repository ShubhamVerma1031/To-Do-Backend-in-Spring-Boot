package com.todo.todo.controller;


import com.todo.todo.model.Task;
import com.todo.todo.repository.TaskRepository;
import com.todo.todo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {
@Autowired
   private Service service;

   @Autowired
   private TaskRepository taskRepository;
    @GetMapping
    private List<Task> getAllTask(){
       List<Task> tasks = service.getAllTask();
        return tasks;
    }


    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addtask(task.getTitle());
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
         service.deleteTask(id);

    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return service.updateTask(id, updatedTask);
    }

    @PutMapping("/complete/{id}")
    public Task markTaskCompleted(@PathVariable Long id) {
        return service.markTaskCompleted(id);
    }


}
