package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class TaskDto {
    private String name;
    private List<String> events;

    public static TaskDto fromEntity(Task task){
        TaskDto dto = new TaskDto();
        dto.setName(task.getName());
        dto.setEvents(task.getEvents());

        return dto;
    }

    public Task toEntity(){
        Task taskEntity = new Task();
        taskEntity.setName(this.getName());
        taskEntity.setEvents(this.getEvents());

        return taskEntity;
    }
}
