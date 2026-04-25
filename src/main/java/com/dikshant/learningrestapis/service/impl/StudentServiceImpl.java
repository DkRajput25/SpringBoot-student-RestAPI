package com.dikshant.learningrestapis.service.impl;

import com.dikshant.learningrestapis.dto.AddStudentRequestDto;
import com.dikshant.learningrestapis.dto.StudentDto;
import com.dikshant.learningrestapis.entity.Student;
import com.dikshant.learningrestapis.repository.StudentRepository;
import com.dikshant.learningrestapis.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

//        List<StudentDto> studentDtos = students
//                .stream()
//                .map(student ->new StudentDto(student.getId(),student.getName(),student.getEmail()))
//                .toList();
        return students
                .stream()
//                .map(student ->new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Student not found"));
        return modelMapper.map(student, StudentDto.class);

    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.save(modelMapper.map(addStudentRequestDto, Student.class));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Student not found"));
        modelMapper.map(addStudentRequestDto,student);

//        student = studentRepository.save(student);
//        return modelMapper.map(student,Student.class);

        return modelMapper.map(studentRepository.save(student),StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Student not found"));

        updates.forEach((field,value)->{
            switch (field) {
                case "name":
                    student.setName((String) value);

                    break;

                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }

}
