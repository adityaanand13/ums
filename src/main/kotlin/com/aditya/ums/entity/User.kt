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
        open var username: String? = null,

        @Column(name = "password")
        open var password: String,

        @Column(name = "first_name")
        open var firstName: String,

        @Column(name = "last_name")
        open var lastName: String? = null,

        @Column(name = "email")
        open var email: String,

        @Column(name = "DOB")
        open var DOB: LocalDate = LocalDate.now(),

        @Enumerated(EnumType.STRING)
        @Column(name = "gender")
        open var gender: Gender = Gender.UNDEFINED,

        @Column(name = "phone")
        open var phone: String = "",

        @Enumerated(EnumType.STRING)
        @Column(name = "blood")
        open var blood: Blood = Blood.UNDEFINED,

        @Enumerated(EnumType.STRING)
        @Column(name = "religion")
        open var religion: Religion = Religion.UNDEFINED,

        @Enumerated(EnumType.STRING)
        @Column(name = "category")
        open var category: Category = Category.GENERAL,

        @Column(name = "aadhar_number")
        open var aadhar: Long = 0L,

        @Enumerated(EnumType.STRING)
        @Column(name = "type")
        open var userType: UserType = UserType.NORMAL,

        @Column(name = "address")
        open var address: String = "",

        @Column(name = "city")
        open var city: String = "",

        @Column(name = "state")
        open var state: String = "",

        @Column(name = "pin_code")
        open var pinCode: Int = 0,

        @Column(name = "country")
        open var country: String = "India",

        //todo add created at, created by, modified at, modified by

        //one users can have many roles
        @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_roles",
                joinColumns = [JoinColumn(name = "user_id")],
                inverseJoinColumns = [JoinColumn(name = "role_id")]
        )
        open var roles: MutableList<Role> = mutableListOf()

)

