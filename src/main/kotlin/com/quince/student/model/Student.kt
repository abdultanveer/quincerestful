package com.quince.student.model

import jakarta.persistence.*

@Entity
@Table(name = "students")
data class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val email: String
)
