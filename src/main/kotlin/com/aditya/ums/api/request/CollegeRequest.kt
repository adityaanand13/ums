package com.aditya.ums.api.request

class CollegeRequest (
        var id: Int,
        var name: String,
        var code: String,
        var address: String = "",
        var phone: String ="",
        var email: String =""
)