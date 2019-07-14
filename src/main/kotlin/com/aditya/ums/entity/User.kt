package com.aditya.ums.entity

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.OneToOne

@Entity
@Table(name = "user")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "email")
    var email: String,

    @Column(name = "DOB")
    var DOB: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    var gender: Gender,

    @Column(name = "phone")
    var phone: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "blood")
    var blood: Blood,

    @Enumerated(EnumType.STRING)
    @Column(name = "religion")
    var religion : Religion,

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    var category : Category,

    @Column(name = "aadhar_number")
    var aadhar: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    var userType: UserType,

    @Column(name = "password")
    var password: String,

    //address
    @Column(name = "address")
    var address: String,

    @Column(name = "city")
    var city: String,

    @Column(name = "state")
    var state: String,

    @Column(name = "pin_code")
    var pinCode: String,

    @Column(name = "country")
    var country: String,

    @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)])
    var student: Student? = null,

    @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)])
    var instructor: Instructor? = null,

    @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)])
    var principal: Principal? = null
)
