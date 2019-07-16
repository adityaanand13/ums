package com.aditya.ums.service

import com.aditya.ums.api.request.BatchRequest
import com.aditya.ums.api.request.SemesterRequest
import com.aditya.ums.converter.BatchConverter
import com.aditya.ums.entity.Batch
import com.aditya.ums.entity.Semester
import com.aditya.ums.repository.BatchRepository
import org.springframework.stereotype.Service

@Service
class BatchService (
        private val batchRepository: BatchRepository,
        private val semesterService: SemesterService
){
    fun getAll(): List<Batch>{
        return batchRepository.findAll()
    }

    fun create(batchRequest: BatchRequest): Batch{
        return batchRepository.save(BatchConverter.convertToEntity(batchRequest))
    }

    fun getById(id: Int): Batch{
        return batchRepository.getOne(id)
    }

    fun getAllByCourseId(courseId: Int): List<Batch>{
        return batchRepository.getAllByCourse_Id(courseId)
    }

    fun addSemester(batchID: Int, semesterRequest: SemesterRequest): Batch{
        var batch = batchRepository.getOne(batchID)
        if(batch!= null){
            val semester: Semester = semesterService.create(semesterRequest)
            semester.batch=batch
            batch.semesters.add(semester)
            batch = batchRepository.save(batch)
        }
        return batch
    }
}