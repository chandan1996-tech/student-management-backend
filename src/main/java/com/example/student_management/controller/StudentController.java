package com.example.student_management.controller;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentDto createStudent(
            @Valid @RequestBody StudentDto dto) {

        return service.createStudent(dto);

    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(
            @PathVariable Long id) {

        return service.getStudentById(id);

    }

    @GetMapping
    public List<StudentDto> getAllStudents() {

        return service.getAllStudents();

    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto dto) {

        return service.updateStudent(id, dto);

    }

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return "Student deleted successfully";

    }

}