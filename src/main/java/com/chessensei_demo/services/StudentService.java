package com.chessensei_demo.services;

import com.chessensei_demo.payload.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto newStudentDetails(StudentDto studentDto);

    List<StudentDto> getAllStudentDetails();

    StudentDto getStudentDetailsById(long id);

    StudentDto updateStudentDetailsById(StudentDto studentDto, long id);

    void deleteStudentDetailsById(long id);
}
