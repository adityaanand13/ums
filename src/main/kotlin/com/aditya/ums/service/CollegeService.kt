package com.aditya.ums.service

import com.aditya.ums.api.request.CollegeRequest
import com.aditya.ums.api.request.CourseRequest
import com.aditya.ums.converter.CollegeConverter
import com.aditya.ums.entity.College
import com.aditya.ums.entity.CollegePrincipal
import com.aditya.ums.entity.Course
import com.aditya.ums.repository.CollegePrincipalRepository
import com.aditya.ums.repository.CollegeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeService(
        @Autowired private val collegeRepository: CollegeRepository,
        @Autowired private val collegePrincipalRepository: CollegePrincipalRepository,
        @Autowired private val courseService: CourseService,
        @Autowired private val InstructorService: InstructorService
) {

    fun getAll(): List<College> {
        return collegeRepository.findAll()
    }

    fun create(collegeRequest: CollegeRequest): College {
        return collegeRepository.save(CollegeConverter.convertToEntity((collegeRequest)))
    }

    fun update(collegeRequest: CollegeRequest): College {
        val college = getById(collegeRequest.id)
        //todo refactor null
        college.name = collegeRequest.name
        college.code = collegeRequest.code
        college.address = collegeRequest.address
        return collegeRepository.save(college)
    }

    fun searchByName(name: String): College {
        return collegeRepository.findFirstByName(name)
    }

    fun getById(id: Int): College {
        return collegeRepository.getOne(id)
    }

    fun deleteById(id: Int) {
        collegeRepository.deleteById(id)
    }

    fun addCourse(collegeID: Int, courseRequest: CourseRequest): College {
        var college = collegeRepository.getOne(collegeID)
        val course: Course = courseService.create(courseRequest)
        course.college = college
        college.courses.add(course)
        college = collegeRepository.save(college)
        return college
    }

    fun assignPrincipal(collegeID: Int, instructor_id: Int): College {
        var college: College = collegeRepository.getOne(collegeID)
        val principal = InstructorService.getById(instructor_id)
        //todo upgrade the role of the principal
        if (college.collegePrincipal == null){
            college.collegePrincipal = CollegePrincipal(principal = instructor_id, college = college)
            college = collegeRepository.save(college)
        }else{
            college.collegePrincipal?.principal = instructor_id
        }
        return college
    }

}