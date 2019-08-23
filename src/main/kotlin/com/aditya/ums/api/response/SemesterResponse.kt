package com.aditya.ums.api.response

import com.aditya.ums.entity.Section

class SemesterResponse (
    var id: Int? =null,
    var name: String,
    var description: String,
    var sections: List<SectionResponse>
)