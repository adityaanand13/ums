package com.aditya.ums.enums

/*
    var Category =["ST","SC","OBC","BC-A","BC-B","General","FF"]

    FF : Freedom Fighters,
    BC-A : Backward caste group A,
    BC-B: Backward caste group B
    ST : Scheduled Tribe
    SC : Scheduled Caste
    OBC : Other backward caste
 */

enum class Category (category: String) {
    GENERAL("General"),
    FF("Freedom Fighters"),
    BCA ( "Backward caste group A"),
    BCB("Backward caste group B"),
    ST ("Scheduled Tribe"),
    SC ("Scheduled Caste"),
    OBC ("Other backward caste");


    companion object  {
        fun toEnum(key: String?): Category ? {
            if (key == null) {
                return null
            }
            return Category.valueOf(key.toUpperCase())
        }
    }
}