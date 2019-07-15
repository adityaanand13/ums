package com.aditya.ums.service

import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.converter.CollegeConverter
import com.aditya.ums.entity.College
import com.aditya.ums.entity.Course
import com.aditya.ums.repository.CollegeRepository
import org.springframework.stereotype.Service

@Service
class CollegeService (
        private val collegeRepository: CollegeRepository,
        private  val courseService: CourseService
) {

    fun getAll(): List<College>{
        return collegeRepository.findAll()
    }

    fun create(collegeRequest: CollegeRequest): College{
        return collegeRepository.save(CollegeConverter.convertToEntity((collegeRequest)))
    }

    fun searchByName(name: String): College{
        return collegeRepository.findFirstByName(name)
    }

    fun addCourse(collegeID: Int, courseRequest: CourseRequest): College{
        var college = collegeRepository.getOne(collegeID)
        if(college!= null){
            val course: Course = courseService.create(courseRequest)
            course.college=college
            college.courses.add(course)
            college = collegeRepository.save(college)
        }
        return college
    }

}