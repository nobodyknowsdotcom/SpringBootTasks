package com.example.demo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TaskDto {
    @Length(min = 1, max = 50)
    @NotBlank
    private String name;
    @Size(min = 1, max = 5)
    private List<@NotBlank @Length(min = 1, max = 50) String> events;

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
