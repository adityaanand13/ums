package com.aditya.ums.entity

import com.aditya.ums.enums.Gender
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int,

        @Column(name = "roll_no")
        var rollNo : Int,

        @Column(name = "first_name")
        var firstName: String,

        @Column(name = "last_name")
        var lastName: String? = null,

        @Column(name = "DOB")
        var DOB: LocalDate,

        //todo refactoring
        @Column(name = "batch")
        var batch : String,

        @Column(name = "email")
        var email: String,

        @Column(name = "gender")
        var gender: Gender,

        @Column(name = "phone")
        var phone: String,

        //todo refactoring blood group enum
        @Column(name = "blood")
        var blood: String,


        //todo refactor address
//        address: [{
//        house: String,
//        street: String,
//        city: String,
//        state: String,
//        areaCode: Number,
//        country: String
//}],
        @Column(name = "permanent_address")
        var permanentAddress: String,

        @Column(name = "local_address")
        var localAddress: String,

        //todo refactoring nationality
        @Column(name = "blood")
        var nationality: String,

        //todo refactoring enum religion
        @Column(name = "religion")
        var religion : String,

//        var Category =["ST","SC","OBC","BC-A","BC-B","ESM","PHC","General","FF"];
//        var Religion =["Hinduism","Islam", "Christianity","sikhism","Jainism","Zoroastrianism", "Atheist", "Others"];
//        var bloodGroups =["A+","A-","B+","B-","AB+","AB-","O+","O-"];
/*  PHC - Physically Challenged,
    FF : Freedom Fighters,
    BC-A : Backward caste group A, BC-B: Backward caste group B
    ESM : Ex-Serviceman
    ST : Scheduled Tribe
    SC : Scheduled Caste
    OBC : Other backward caste
 */

        //todo refactoring enum category
        @Column(name = "category")
        var category : String,

        //todo refactoring family details
/*        father: {
        name: String,
        contact1: Number,
        contact2: Number,
        income: Number,
        occupation : String
},
mother: {
        name: String,
        contact1: Number,
        contact2: Number,
        income: Number,
        occupation : String
familyIncome: Number,
},*/

        @Column(name = "fathers_name")
        var fathersName: String,

        @Column(name = "fathers_contact")
        var fathersContact: String,

        @Column(name = "mothers_name")
        var mothersName: String,

        @Column(name = "mothers_contact")
        var mothersContact: String,

        @Column(name = "aadhar_number")
        var aadhar: Long


)