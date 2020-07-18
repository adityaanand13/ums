package com.aditya.ums.api.response

class SectionResponse (
    var id: Int? =null,
    var name: String,
    var description: String,
    var groups: List<GroupResponse>? = null

)