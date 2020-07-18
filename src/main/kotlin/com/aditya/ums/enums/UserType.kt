package com.aditya.ums.enums

enum class UserType (userType: String) {
    SUPER("super admin"),
    ADMIN("admin"),
    PRINCIPAL("principal"),
    INSTRUCTOR("instructor"),
    STUDENT("student"),
    NORMAL("normal");

    companion object  {
        fun toEnum(key: String?): UserType ? {
            if (key == null) {
                return null
            }
            return UserType.valueOf(key.toUpperCase())
        }
    }
}