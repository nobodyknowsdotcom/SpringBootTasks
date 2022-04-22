package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String name;
    private List<String> events;

    public static TaskDto fromEntity(Task task){
        TaskDto dto = new TaskDto();
        dto.setName(task.getName());
        dto.setEvents(task.getEvents());

        return dto;
    }
}
