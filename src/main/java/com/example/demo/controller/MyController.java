package com.example.demo.controller;

import com.example.demo.dto.Task;
import com.example.demo.dto.TaskDto;
import com.example.demo.repository.RepositoryTools;
import com.example.demo.repository.TaskRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
public class MyController {
    final TaskRepository repo;
    public MyController(TaskRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String readTask(@Valid @RequestBody Task task) {
        repo.save(task);
        return String.format("Added task with name '%s'.", task.getName());
    }

    @RequestMapping(path="/get", method=RequestMethod.GET)
    public ArrayList<String> returnAllTasks(){
        return RepositoryTools.GetAllTasks(repo);
    }

    @RequestMapping(path="/clear", method=RequestMethod.DELETE)
    public String clearTasks(){
        repo.deleteAll();
        return "Tasks are deleted successfully.";
    }

}
