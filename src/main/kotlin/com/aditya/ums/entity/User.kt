package com.aditya.ums.entity

import com.aditya.ums.enums.*
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
open class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @Column(name = "username")
        var username: String? = null,

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
        var religion: Religion = Religion.UNDEFINED,

        @Enumerated(EnumType.STRING)
        @Column(name = "category")
        var category: Category = Category.GENERAL,

        @Column(name = "aadhar_number")
        var aadhar: Long = 0L,

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

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
        var roles: MutableSet<Role> = mutableSetOf()

)

