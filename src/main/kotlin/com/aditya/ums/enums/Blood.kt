package com.aditya.ums.enums

enum class Blood (blood : String){
    APOS("A+"),
    ANEG("A-"),
    BPOS("B+"),
    BNEG("B-"),
    ABPOS("AB+"),
    ABNEG("AB-"),
    OPOS("O+"),
    ONEG("O-"),
    UNDEFINED("undefined");

    companion object  {
        fun toEnum(key: String?): Blood ? {
            if (key == null) {
                return null
            }
            return Blood.valueOf(key.toUpperCase())
        }
    }
}