package com.example.student_management.mapper;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.entity.Student;

public class StudentMapper {

    private StudentMapper() {
    }

    public static StudentDto mapToStudentDto(Student student) {

        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getCourse()
        );

    }

    public static Student mapToStudent(StudentDto dto) {

        return new Student(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getCourse()
        );

    }

}