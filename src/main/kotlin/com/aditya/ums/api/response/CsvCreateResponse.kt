package com.aditya.ums.api.response

class CsvCreateResponse (
        var success: Boolean,
        var userData: CsvUserResponse,
        var error: List<String>
)