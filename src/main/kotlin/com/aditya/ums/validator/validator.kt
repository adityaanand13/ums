package com.aditya.ums.validator

import java.text.DateFormat
import java.text.SimpleDateFormat


class Validator{
    companion object {
        @JvmStatic
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        fun isEmailValid(email: String): Boolean {
            return EMAIL_REGEX.toRegex().matches(email)
        }

        @JvmStatic
        //todo refactor date format
        fun isDateValid(date: String): Boolean {
            val format: DateFormat = SimpleDateFormat("yyyy-MM-dd")
            format.isLenient
            return SimpleDateFormat("yyyy-MM-dd").parse(date) != null
        }

        //todo add aadhar validator https://stackoverflow.com/questions/27686384/validating-the-aadhar-card-number-in-a-application

        //todo implement phone regex
        @JvmStatic
        val PHONE_REGEX = "^[+]"
        fun isPhoneValid(phone: String): Boolean {
            return PHONE_REGEX.toRegex().matches(phone)
        }
    }
}