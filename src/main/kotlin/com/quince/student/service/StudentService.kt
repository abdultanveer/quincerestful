package com.quince.student.service

import com.quince.student.model.Student
import com.quince.student.repository.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class StudentService(private val repository: StudentRepository) {

    fun createStudent(student: Student): Student =
        repository.save(student)

    fun getAllStudents(): List<Student> =
        repository.findAll()

    fun getStudentById(id: Long): Student =
        repository.findById(id)
            .orElseThrow { RuntimeException("Student not found") }

    fun updateStudent(id: Long, student: Student): Student {
      val myjob =   GlobalScope.launch(Dispatchers.Main){
            //invoke a suspendable fn
        }

        val existing = getStudentById(id)
        val updated = existing.copy(
            name = student.name,
            email = student.email
        )
        return repository.save(updated)
    }

    fun deleteStudent(id: Long) =
        repository.deleteById(id)
}
