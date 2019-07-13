package com.aditya.ums.converter

import com.aditya.ums.api.request.StudentRequest
import com.aditya.ums.api.response.StudentResponse
import com.aditya.ums.entity.Student
import com.aditya.ums.entity.User

class StudentConverter {
    companion object {
        fun convertToResponses(students: List<Student>): List<StudentResponse>{
            return students.map { student -> convertToResponse(student) }
        }

        fun convertToResponse(student: Student): StudentResponse {
            return StudentResponse (
                rollNo = student.rollNo,
                batch = student.batch,
                localAddress = student.localAddress,
                nationality = student.nationality,
                fathersName = student.fathersName,
                fathersPhone = student.fathersPhone,
                fathersIncome = student.fathersIncome,
                fathersOccupation = student.fathersOccupation,
                mothersName = student.mothersName,
                mothersPhone = student.mothersPhone,
                mothersIncome = student.mothersIncome,
                mothersOccupation = student.mothersOccupation,
                familyIncome = student.familyIncome,
                userResponse = UserConverter.convertToResponse(student.user)
            )
        }

        fun convertToEntity(studentRequest: StudentRequest, user: User): Student{
            return Student(
                user = user,
                rollNo = studentRequest.rollNo,
                batch = studentRequest.batch,
                localAddress = studentRequest.localAddress,
                nationality = studentRequest.nationality,
                fathersName = studentRequest.fathersName,
                fathersPhone = studentRequest.fathersPhone,
                fathersIncome = studentRequest.fathersIncome,
                fathersOccupation = studentRequest.fathersOccupation,
                mothersName = studentRequest.mothersName,
                mothersPhone = studentRequest.mothersPhone,
                mothersIncome = studentRequest.mothersIncome,
                mothersOccupation = studentRequest.mothersOccupation,
                familyIncome = studentRequest.familyIncome
            )
        }
    }

}