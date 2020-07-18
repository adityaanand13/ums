package com.aditya.ums.service

import com.aditya.ums.entity.Batch
import com.aditya.ums.repository.BatchRepository
import org.springframework.stereotype.Service

@Service
class BatchService(
        private val batchRepository: BatchRepository,
        private val semesterService: SemesterService
) {
    fun getAll(): List<Batch> {
        return batchRepository.findAll()
    }

    fun existsByName(name: String): Boolean {
        return batchRepository.existsByName(name)
    }

    fun create(batchName: String): Batch {
        val batch: Batch = Batch(name = batchName)
        return batchRepository.save(batch)
    }

    fun getById(id: Int): Batch {
        return batchRepository.getOne(id)
    }

    fun getAllByCourseId(courseId: Int): List<Batch> {
        return batchRepository.getAllByCourse_Id(courseId)
    }
}