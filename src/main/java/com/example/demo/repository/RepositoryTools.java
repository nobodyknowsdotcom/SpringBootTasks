package com.example.demo.repository;

import com.example.demo.dto.Task;
import com.example.demo.dto.TaskDto;

import java.util.ArrayList;

public class RepositoryTools {
    public static ArrayList<TaskDto> getAllTasks(TaskRepository repo){
        var tasks = new ArrayList<TaskDto>();

        for (Task rawTask : repo.findAll()) {
            tasks.add(TaskDto.fromEntity(rawTask));
        }
        return tasks;
    }
}
