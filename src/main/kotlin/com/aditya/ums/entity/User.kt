package com.aditya.ums.entity

import com.aditya.ums.enums.*
import org.springframework.security.core.userdetails.UsernameNotFoundException
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

        @Column(name = "username")
    var username: String,

        @Column(name = "password")
    var password: String,

        @Column(name = "first_name")
    var firstName: String,

        @Column(name = "last_name")
    var lastName: String? = null,

        @Column(name = "email")
    var email: String,

        @Column(name = "DOB")
    var DOB: LocalDate = LocalDate.now(),

        @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    var gender: Gender = Gender.UNDEFINED,

        @Column(name = "phone")
    var phone: String = "",

        @Enumerated(EnumType.STRING)
    @Column(name = "blood")
    var blood: Blood = Blood.UNDEFINED,

        @Enumerated(EnumType.STRING)
    @Column(name = "religion")
    var religion : Religion = Religion.UNDEFINED,

        @Enumerated(EnumType.STRING)
    @Column(name = "category")
    var category : Category = Category.GENERAL,

        @Column(name = "aadhar_number")
    var aadhar: Long= 0L,

        @Enumerated(EnumType.STRING)
    @Column(name = "type")
    var userType: UserType = UserType.NORMAL,

        @Column(name = "address")
    var address: String = "",

        @Column(name = "city")
    var city: String = "",

        @Column(name = "state")
    var state: String = "",

        @Column(name = "pin_code")
    var pinCode: String = "",

        @Column(name = "country")
    var country: String = "India",

        @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)])
    var student: Student? = null,

        @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)])
    var instructor: Instructor? = null,

        @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)])
    var principal: Principal? = null
)
