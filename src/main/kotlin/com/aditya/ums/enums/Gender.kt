package com.aditya.ums.enums

enum class Gender(gender: String) {
    MALE("male"),
    FEMALE("female");

    companion object  {
        fun toEnum(key: String?): Gender? {
            if (key == null) {
                return null
            }
            return Gender.valueOf(key.toUpperCase())
        }
    }
}