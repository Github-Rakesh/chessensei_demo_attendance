package com.chessensei_demo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDto {
    private long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String parentName;

    @NotNull
    @NotEmpty
    private String dateOfJoining;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10, message = "Mobile number must have 10 numbers!")
    private String mobileNumber;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10, message = "Mobile number must have 10 numbers!")
    private String whatsAppNumber;

    @NotNull
    @NotEmpty
    @Email(message = "Email format not valid!")
    private String email;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String society;

    @NotNull
    @NotEmpty
    private String classSpecification;
}
