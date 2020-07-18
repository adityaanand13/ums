package com.aditya.ums.service

import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.converter.CourseConverter
import com.aditya.ums.entity.Batch
import com.aditya.ums.entity.Course
import com.aditya.ums.entity.Semester
import com.aditya.ums.exception.ConflictException
import com.aditya.ums.repository.CourseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.HttpClientErrorException

@Service
class CourseService(
        private val courseRepository: CourseRepository,
        private val batchService: BatchService
) {
    fun getAll(): List<Course> {
        return courseRepository.findAll()
    }

    fun create(courseRequest: CourseRequest): Course {
//        if(studentRequest.rollNo == null || studentRequest.batch.isBlank()) {
//            throw BadRequestException("Invalid Request")
//        }
        return courseRepository.save(
                CourseConverter.convertToEntity(courseRequest)
        )
    }

    fun getById(id: Int): Course {
        return courseRepository.getOne(id)
    }

    fun getAllByCollegeId(collegeId: Int): List<Course> {
        return courseRepository.getAllByCollege_Id(collegeId)
    }

    @Transactional
    @Throws(ConflictException::class)
    fun addBatch(courseID: Int, startYear: Int): Course {
        var course = courseRepository.getOne(courseID)
        val batchName = "${course.code}:${startYear}-${(startYear + course.duration)}"
        if(batchService.existsByName(batchName)){
            throw ConflictException(fieldName = "name", fieldValue = startYear)
        }
        val batch: Batch = batchService.create(batchName);
        val totalSemester = course.duration * course.semesterPerYear
        for (i in 1..totalSemester) {
            val semester: Semester = Semester(
                    name = "${batch.name}:${getDayNumberSuffix(i)} Semester",
                    seq = i
            )
            semester.batch = batch
            batch.semesters.add(semester)
        }
        batch.course = course
        course.batches.add(batch)
        course = courseRepository.save(course)
        return course
    }

    private fun getDayNumberSuffix(i: Int): String? {
        return if (i in 11..13) {
            "${i}th"
        } else when (i % 10) {
            1 -> "${i}st"
            2 -> "${i}nd"
            3 -> "${i}rd"
            else -> "${i}th"
        }
    }
}