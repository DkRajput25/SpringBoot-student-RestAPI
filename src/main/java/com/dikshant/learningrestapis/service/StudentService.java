package com.dikshant.learningrestapis.service;

import com.dikshant.learningrestapis.dto.AddStudentRequestDto;
import com.dikshant.learningrestapis.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    @Nullable StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    com.dikshant.learningrestapis.dto.@Nullable StudentDto updateStudent(Long id, com.dikshant.learningrestapis.dto.AddStudentRequestDto addStudentRequestDto);

    com.dikshant.learningrestapis.dto.@Nullable StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
