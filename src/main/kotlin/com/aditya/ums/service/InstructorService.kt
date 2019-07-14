package com.aditya.ums.service

import com.aditya.ums.api.request.InstructorRequest
import com.aditya.ums.converter.InstructorConverter
import com.aditya.ums.entity.Instructor
import com.aditya.ums.entity.User
import com.aditya.ums.enums.UserType
import com.aditya.ums.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class InstructorService (
        private val userService: UserService,
        private val instructorRepository: InstructorRepository,
        private val courseService: CourseService
){
    //returns list of all the instructors in the DB
    fun getAll(): List<Instructor> {
        return instructorRepository.findAll()
    }

    fun create(instructorRequest: InstructorRequest) : Instructor {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        val user: User = userService.createUser(instructorRequest.user)
        return instructorRepository.
            save(
                InstructorConverter.convertToEntity(instructorRequest, user)
            )
    }

    fun searchByName(firstName: String): Instructor {
        return instructorRepository.
                findFirstByUserFirstNameAndUserUserType(firstName, UserType.INSTRUCTOR)
    }

    fun getByEmployeeID(employeeID: Int): Instructor{
        return instructorRepository.findFirstByEmployeeID(employeeID)
    }

//    fun addCourse(addCourseRequest: AddCourseRequest): Instructor{
//        var instructor = getByEmployeeID(addCourseRequest.employeeID)
//        if(instructor!= null){
//            var course = courseService.getById(addCourseRequest.courseID)
//            if (course!=null){
//                course.instructor=instructor
//                instructor.courses!!.add(course)
//                instructor = instructorRepository.save(instructor)
//            }
//        }
//        return instructor
//    }
}
