package com.aditya.ums.service

import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.api.response.CourseResponse
import com.aditya.ums.converter.CourseConverter
import com.aditya.ums.entity.Course
import com.aditya.ums.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
        private val studentService: StudentService,
        private val instructorService: InstructorService,
        private val courseRepository: CourseRepository
) {
    fun getAll(): List<CourseResponse>{
        return CourseConverter.convertToResponses(courseRepository.findAll())
    }

    fun create(courseRequest: CourseRequest) : Course {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        return courseRepository.
                save(
                        CourseConverter.convertToEntity(courseRequest)
                )
    }
}