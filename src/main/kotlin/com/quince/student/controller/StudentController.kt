package com.quince.student.controller

import com.quince.student.model.Student
import com.quince.student.service.StudentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController(private val service: StudentService) {

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student =
        service.createStudent(student)

    @GetMapping
    fun getAllStudents(): List<Student> =
        service.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): Student =
        service.getStudentById(id)

    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Long,
        @RequestBody student: Student
    ): Student =
        service.updateStudent(id, student)

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long) =
        service.deleteStudent(id)
}
