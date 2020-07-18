package com.aditya.ums.enums

enum class RoleType (role : String){
    ROLE_USER("role_user"),
    ROLE_SUPER("role_super"),
    ROLE_ADMIN("role_admin"),
    ROLE_PRINCIPAL("role_principal"),
    ROLE_INSTRUCTOR("role_instructor"),
    ROLE_STUDENT("role_student"),
    ROLE_NORMAL("role_normal");

    companion object  {
        fun toEnum(key: String?): UserType ? {
            if (key == null) {
                return null
            }
            return UserType.valueOf(key.toUpperCase())
        }
    }
}