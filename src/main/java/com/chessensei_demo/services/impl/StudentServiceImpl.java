package com.chessensei_demo.services.impl;

import com.chessensei_demo.entities.Student;
import com.chessensei_demo.exception.ResourceNotFoundException;
import com.chessensei_demo.payload.StudentDto;
import com.chessensei_demo.repository.StudentRepository;
import com.chessensei_demo.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;

    private ModelMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepo, ModelMapper mapper) {
        this.studentRepo = studentRepo;
        this.mapper = mapper;
    }

    @Override
    public StudentDto newStudentDetails(StudentDto studentDto) {
        Student student = mapToEntity(studentDto);
        Student studentEntity = studentRepo.save(student);
        StudentDto dto = mapToDto(studentEntity);
        return dto;
    }

    @Override
    public List<StudentDto> getAllStudentDetails() {
        List<Student> allStudents = studentRepo.findAll();
        return allStudents.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentDetailsById(long id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
        StudentDto studentDto = mapToDto(student);
        return studentDto;
    }

    @Override
    public StudentDto updateStudentDetailsById(StudentDto studentDto, long id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );

        student.setName(studentDto.getName());
        student.setParentName(studentDto.getParentName());
        student.setDateOfJoining(studentDto.getDateOfJoining());
        student.setMobileNumber(studentDto.getMobileNumber());
        student.setWhatsAppNumber(studentDto.getWhatsAppNumber());
        student.setEmail(studentDto.getEmail());
        student.setCity(studentDto.getCity());
        student.setSociety(studentDto.getSociety());
        student.setClassSpecification(studentDto.getClassSpecification());

        Student save = studentRepo.save(student);

        return mapToDto(save);
    }

    @Override
    public void deleteStudentDetailsById(long id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
        studentRepo.delete(student);
    }

    public Student mapToEntity(StudentDto studentDto){
        Student student = mapper.map(studentDto, Student.class);
        return student;
    }

    public StudentDto mapToDto(Student student){
        StudentDto dto = mapper.map(student, StudentDto.class);
        return dto;
    }
}
