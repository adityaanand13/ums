package com.aditya.ums.enums

enum class UserType (userType: String) {
    ADMIN("admin"),
    STUDENT("student");


    companion object  {
        fun toEnum(key: String?): UserType ? {
            if (key == null) {
                return null
            }
            return UserType.valueOf(key.toUpperCase())
        }
    }
}