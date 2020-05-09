package com.aditya.ums.api.response

class SemesterResponse(
        var id: Int? = null,
        var name: String,
        var isActive: Boolean,
        var seq: Int,
        var sections: List<SectionResponse> = ArrayList(),
        var subjects: List<SubjectResponse> = ArrayList()
)