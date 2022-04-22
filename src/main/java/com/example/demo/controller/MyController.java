package com.example.demo.controller;

import com.example.demo.dto.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    final
    TaskRepository repo;

    public MyController(TaskRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String readTask(@RequestBody Task task) {
        repo.save(task);
        return String.valueOf(repo.count());
    }
}
