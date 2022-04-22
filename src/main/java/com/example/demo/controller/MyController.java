package com.example.demo.controller;

import com.example.demo.dto.Task;
import com.example.demo.dto.TaskDto;
import com.example.demo.repository.TaskRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    final TaskRepository repo;
    public MyController(TaskRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String readTask(@RequestBody Task task) {
        repo.save(task);
        return String.valueOf(repo.count());
    }
    @RequestMapping(path="/get", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String returnAllTasks(){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        var tasks = new ArrayList<String>();

        repo.findAll().forEach(rawTask -> {
            try {
                tasks.add(ow.writeValueAsString(TaskDto.fromEntity(rawTask)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        var json = String.join("\n", tasks);
        return json;
    }
}
