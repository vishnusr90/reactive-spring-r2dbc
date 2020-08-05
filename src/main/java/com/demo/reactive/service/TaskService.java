package com.demo.reactive.service;

import com.demo.reactive.entity.Task;
import com.demo.reactive.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Flux<Task> getAllTasks() {
        return this.taskRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Task> addTask(Task task) {
        return this.taskRepository.save(task);
    }
}
