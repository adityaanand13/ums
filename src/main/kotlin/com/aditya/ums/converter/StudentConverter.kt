package com.aditya.ums.converter

import com.aditya.ums.api.response.StudentResponse
import com.aditya.ums.entity.Student

class StudentConverter {
    companion object {
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
    }

}