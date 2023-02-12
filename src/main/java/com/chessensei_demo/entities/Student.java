package com.chessensei_demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parent_name", nullable = false)
    private String parentName;

    @Column(name = "date_of_joining", nullable = false)
    private String dateOfJoining;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "whats_app_number", nullable = false)
    private String whatsAppNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "society", nullable = false)
    private String society;

    @Column(name = "class_specification", nullable = false)
    private String classSpecification;
}
