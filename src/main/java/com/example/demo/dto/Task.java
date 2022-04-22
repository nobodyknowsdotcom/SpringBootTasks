package com.example.demo.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @Column(name = "event")
    @ElementCollection
    @NotNull
    private List<String> events;
}
