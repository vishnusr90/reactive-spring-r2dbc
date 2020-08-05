package com.demo.reactive.controller;

import com.demo.reactive.entity.Task;
import com.demo.reactive.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public Flux<Task> getAllTasks() {
        return this.taskService.getAllTasks();
    }

    @PostMapping("")
    public Mono<Task> addTask(@RequestBody Task task) {
        return this.taskService.addTask(task);
    }
}
