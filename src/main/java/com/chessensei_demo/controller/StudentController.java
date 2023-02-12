package com.chessensei_demo.controller;

import com.chessensei_demo.payload.StudentDto;
import com.chessensei_demo.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Object> newStudentDetails(@Valid @RequestBody StudentDto studentDto,
                                                        BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        StudentDto dto = studentService.newStudentDetails(studentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentDto> getAllStudentDetails(){
        List<StudentDto> allStudentDetails = studentService.getAllStudentDetails();
        return allStudentDetails;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") long id){
        StudentDto studentDetailsById = studentService.getStudentDetailsById(id);
        return ResponseEntity.ok(studentDetailsById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentDetailsById(@RequestBody StudentDto studentDto,
                                                               @PathVariable("id") long id){
        StudentDto dto = studentService.updateStudentDetailsById(studentDto, id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentDetailsById(@PathVariable("id") long id){
        studentService.deleteStudentDetailsById(id);
        return new ResponseEntity<>("Student details delete successfully!",HttpStatus.OK);
    }
}
