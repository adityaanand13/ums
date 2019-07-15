package com.aditya.ums.service

import com.aditya.ums.api.request.BatchRequest
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.converter.CourseConverter
import com.aditya.ums.entity.Batch
import com.aditya.ums.entity.Course
import com.aditya.ums.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
        private val courseRepository: CourseRepository,
        private val batchService: BatchService
) {
    fun getAll(): List<Course>{
        return courseRepository.findAll()
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

    fun getById(id: Int): Course{
        return courseRepository.getOne(id)
    }

    fun getAllByCollegeId(collegeId: Int): List<Course>{
        return courseRepository.getAllByCollege_Id(collegeId)
    }

    fun addBatch(courseID: Int, batchRequest: BatchRequest): Course{
        var course = courseRepository.getOne(courseID)
        if(course!= null){
            val batch: Batch = batchService.create(batchRequest)
            batch.course=course
            course.batches.add(batch)
            course = courseRepository.save(course)
        }
        return course
    }
}