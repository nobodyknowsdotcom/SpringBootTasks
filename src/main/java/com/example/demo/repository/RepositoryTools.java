package com.example.demo.repository;

import com.example.demo.dto.TaskDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;

public class RepositoryTools {
    public static ArrayList<String> GetAllTasks(TaskRepository repo){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        var tasks = new ArrayList<String>();

        repo.findAll().forEach(rawTask -> {
            try {
                tasks.add(ow.writeValueAsString(TaskDto.fromEntity(rawTask)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return tasks;
    }
}
