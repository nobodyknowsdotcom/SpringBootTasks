package com.example.demo.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Column(name = "name")
    @NotEmpty
    private String name;
    @Column(name = "event")
    @ElementCollection
    @Size(min = 1, max = 5)
    private List<String> events;
}
