package com.example.student_management.service;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {

        Student student = StudentMapper.mapToStudent(dto);

        Student savedStudent = repository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);

    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found with id : " + id));

        return StudentMapper.mapToStudentDto(student);

    }

    @Override
    public List<StudentDto> getAllStudents() {

        return repository.findAll()
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();

    }

    @Override
    public StudentDto updateStudent(Long id,
                                    StudentDto dto) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found"));

        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        Student updatedStudent = repository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudent);

    }

    @Override
    public void deleteStudent(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found"));

        repository.delete(student);

    }

}