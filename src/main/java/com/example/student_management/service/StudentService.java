package com.example.student_management.service;

import com.example.student_management.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long id,
                             StudentDto studentDto);

    void deleteStudent(Long id);

}