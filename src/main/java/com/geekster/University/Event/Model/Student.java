package com.geekster.University.Event.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private  Integer studentId;

    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$")
    private String firstName;

    private String lastName;
    @Min(18) @Max(25)
    private int age;

    private Department department;

}
