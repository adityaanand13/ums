package com.aditya.ums.api.controller

//import com.aditya.ums.api.response.Response
//import org.springframework.boot.web.servlet.error.ErrorController
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//
//@RestController
//class AppErrorController: ErrorController {
//    companion object{
//        private const val ERROR_MAPPING = "/error"
//    }
//
//
//    @RequestMapping(value = [ERROR_MAPPING])
//    fun error(): ResponseEntity<Response> {
//        val message = "not found beta"
//        val response = Response()
//                .data(message)
//                .httpStatusCode(HttpStatus.NOT_FOUND.value())
//                .contentType("application/json")
//
//        return ResponseEntity(response, HttpStatus.NOT_FOUND)
//    }
//
//    override fun getErrorPath(): String {
//        return ERROR_MAPPING;
//    }
//
//    /**
//     * Supports other formats like JSON, XML
//     *
//     *
//
//    @RequestMapping(value )
//    @ResponseBody
//    fun error(request: HttpServletRequest): ResponseEntity<Map<String, Any?>> {
//        val body = getErrorAttributes(request, getTraceParameter(request))
//        val status = getStatus(request)
//        return ResponseEntity(body, status)
//    }*/
//
//
//
//}