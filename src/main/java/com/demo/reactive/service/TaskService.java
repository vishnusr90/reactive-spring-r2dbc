package com.demo.reactive.service;

import com.demo.reactive.entity.Task;
import com.demo.reactive.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Flux<Task> getAllTasks() {
        return this.taskRepository.findAll()
                .delayElements(Duration.ofSeconds(2))
                .switchIfEmpty(Flux.empty());
    }

    public Mono<Task> addTask(Task task) {
        return this.taskRepository.save(task);
    }

    public Mono<Task> updateTask(final Task task) {
        return this.taskRepository.findById(task.getId())
                .flatMap(t -> {
                    t.setCompleted(task.getCompleted());
                    t.setDescription(task.getDescription());
                    return this.taskRepository.save(t);
                });
    }

    public Mono<Void> deleteTask(final Long id) {
        return this.taskRepository.findById(id)
                .flatMap(this.taskRepository::delete);
    }
}
