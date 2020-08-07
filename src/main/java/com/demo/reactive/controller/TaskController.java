package com.demo.reactive.controller;

import com.demo.reactive.entity.Task;
import com.demo.reactive.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Task> getAllTasks() {
        return this.taskService.getAllTasks();
    }

    @PostMapping("")
    public Mono<Task> addTask(@RequestBody Task task) {
        return this.taskService.addTask(task);
    }

    @PutMapping("")
    public Mono<Task> updateTask(@RequestBody Task task) { return this.taskService.updateTask(task); }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTask(@PathVariable Long id) {
         return this.taskService.deleteTask(id);
    }
}
