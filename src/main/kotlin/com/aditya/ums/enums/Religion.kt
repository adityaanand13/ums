package com.aditya.ums.enums

enum class Religion (religion: String) {
    HINDUISM("hinduism"),
    ISLAM("islam"),
    CHRISTIANITY("christianity"),
    SIKHISM("sikhism"),
    JAINISM("jainism"),
    ZOROASTRIANISM("zoroastrianism"),
    ATHEIST("atheist"),
    OTHERS("others"),
    UNDEFINED("undefined");


    companion object  {
        fun toEnum(key: String?): Religion ? {
            if (key == null) {
                return null
            }
            return Religion.valueOf(key.toUpperCase())
        }
    }
}