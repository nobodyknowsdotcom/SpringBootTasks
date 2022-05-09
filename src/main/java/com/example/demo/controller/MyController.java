package com.example.demo.controller;

import com.example.demo.dto.TaskDto;
import com.example.demo.repository.RepositoryTools;
import com.example.demo.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
public class MyController {
    final TaskRepository repo;
    public MyController(TaskRepository repo) {
        this.repo = repo;
    }

    @PostMapping(path="/add")
    public String readTask(@Valid @RequestBody TaskDto task) {
        repo.save(task.toEntity());
        return String.format("Added task with name '%s'.", task.getName());
    }

    @GetMapping(path="/get")
    public ArrayList<TaskDto> returnAllTasks(){
        return RepositoryTools.getAllTasks(repo);
    }

    @DeleteMapping(path="/clear")
    public String clearTasks(){
        repo.deleteAll();
        return "Tasks are deleted successfully.";
    }

}
