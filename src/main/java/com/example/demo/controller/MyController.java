package com.example.demo.controller;

import com.example.demo.dto.Task;
import com.example.demo.dto.TaskDto;
import com.example.demo.repository.TaskRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class MyController {
    final TaskRepository repo;
    public MyController(TaskRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String readTask(@RequestBody Task task) {
        repo.save(task);
        return String.valueOf(repo.count());
    }
    @RequestMapping(path="/get", method=RequestMethod.GET)
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
        return String.join("\n", tasks);
    }
    @RequestMapping(path="/clear", method=RequestMethod.DELETE)
    public String clearTasks(){
        repo.deleteAll();
        return "Tasks are deleted successfully.";
    }

}
